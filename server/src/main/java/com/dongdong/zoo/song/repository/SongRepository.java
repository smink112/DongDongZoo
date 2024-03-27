package com.dongdong.zoo.song.repository;

import com.dongdong.zoo.song.dto.SongDetailResponse;
import com.dongdong.zoo.song.dto.SongLikeCountResponse;
import com.dongdong.zoo.song.dto.SongListResponse;
import com.dongdong.zoo.song.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    // 인기 동요 조회
    // 좋아요, 조회수 내림차순 DESC 정렬
    @Query("SELECT new com.dongdong.zoo.song.dto.SongListResponse(s.songId, s.songName, s.songImageUrl, s.views, count(sl.id) as likeCount) " +
            "FROM Song s LEFT JOIN SongLikes sl ON s.songId = sl.song.songId " +
            "GROUP BY s.songId, s.songName, s.songImageUrl, s.songFileUrl, s.views, s.beat " +
            "ORDER BY s.views DESC, likeCount DESC")
    List<SongListResponse> findSongsByLikesAndViews();

    @Query("SELECT s FROM Song s WHERE s.songId = :songId")
    Song findSongBySongId(Long songId);

    @Query("SELECT new com.dongdong.zoo.song.dto.SongLikeCountResponse(s.songId, count(sl.id) as likeCount) " +
            "FROM Song s LEFT JOIN SongLikes sl ON s.songId = sl.song.songId " +
            "WHERE s.songId = :songId " +
            "GROUP BY s.songId ")
    SongLikeCountResponse findSongLikeCountBySongId(Long songId);

}
