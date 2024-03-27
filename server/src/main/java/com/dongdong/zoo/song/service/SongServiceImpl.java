package com.dongdong.zoo.song.service;

import com.dongdong.zoo.song.dto.SongDetailResponse;
import com.dongdong.zoo.song.dto.SongLikeCountResponse;
import com.dongdong.zoo.song.dto.SongListResponse;
import com.dongdong.zoo.song.model.Song;
import com.dongdong.zoo.song.model.Lyrics;
import com.dongdong.zoo.song.model.SongKeyword;
import com.dongdong.zoo.song.repository.SongRepository;
import com.dongdong.zoo.user.repository.UserRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService{

    private final SongRepository songRepository;
    private final UserRepository userRepository;

    public SongServiceImpl(SongRepository songRepository, UserRepository userRepository) {
        this.songRepository = songRepository;
        this.userRepository = userRepository;
    }


    // 좋아요, 조회수 내림차순으로 인기 동요 조회
    @Override
    @Transactional
    public List<SongListResponse> getSongsByLikesAndViews() {
        return songRepository.findSongsByLikesAndViews();

//        return songRepository.findSongsByLikesAndViews().stream().map(this::getSongListResponse).collect(Collectors.toList());
    }

    // 동요 상세 조회
    @Override
    @Transactional
    public SongDetailResponse getSongBySongId(Long songId){
        Song song = songRepository.findSongBySongId(songId);
        return getSongResponse(song);
    }

    @Override
    public Song findById(Long songId){
        return songRepository.findSongBySongId(songId);
    }


    @Override
    public void viewCountUp(Long songId){

        Song song = findById(songId);
        song.viewCountUp(song);
    }

    private SongListResponse getSongListResponse(Song song) {

        return SongListResponse.builder()
                .songId(song.getSongId())
                .songName(song.getSongName())
                .songImageUrl(song.getSongImageUrl())
                .views(song.getViews())
                .build();
    }

    private SongDetailResponse getSongResponse(Song song){
        List<String> lyricsList = song.getLyricsList().stream()
                .map(Lyrics::getContent)
                .collect(Collectors.toList());

        SongLikeCountResponse likeCount = songRepository.findSongLikeCountBySongId(song.getSongId());

        List<String> songKeywordList = song.getSongKeywordList().stream()
                .map(SongKeyword::getSongKeyword)
                .collect(Collectors.toList());

        return SongDetailResponse.builder()
                .songId(song.getSongId())
                .songName(song.getSongName())
                .songImageUrl(song.getSongImageUrl())
                .songFileUrl(song.getSongFileUrl())
                .beat(song.getBeat())
                .views(song.getViews())
                .lyricsList(lyricsList)
                .LikeCount(likeCount.getLikeCount())
                .songKeywordList(songKeywordList)
                .build();
    }
}
