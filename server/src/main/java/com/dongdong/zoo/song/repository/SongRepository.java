package com.dongdong.zoo.song.repository;

import com.dongdong.zoo.song.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    // 인기 동요 조회
    // 좋아요, 조회수 내림차순 DESC 정렬
    // 노래정보들 + 좋아요 여부, 좋아요 개수 반환 해야함
    @Query("SELECT s.songId FROM Song s order by s.views DESC")
    List<Song> findSongsByLikesAndViews();
}
