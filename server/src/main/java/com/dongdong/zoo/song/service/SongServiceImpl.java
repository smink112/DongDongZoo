package com.dongdong.zoo.song.service;

import com.dongdong.zoo.song.dto.SongDetailResponse;
import com.dongdong.zoo.song.dto.SongListResponse;
import com.dongdong.zoo.song.model.Song;
import com.dongdong.zoo.song.model.Lyrics;
import com.dongdong.zoo.song.repository.SongRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService{

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }


    // 좋아요, 조회수 내림차순으로 인기 동요 조회
    @Override
    @Transactional
    public List<SongListResponse> getSongsByLikesAndViews() {

        return songRepository.findSongsByLikesAndViews().stream().map(this::getSongListResponse).collect(Collectors.toList());
    }

    // 동요 상세 조회
    @Override
    @Transactional
    public SongDetailResponse getSongBySongId(Long songId){
        Song song = songRepository.findSongBySongId(songId);
        return getSongResponse(song);
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

        return SongDetailResponse.builder()
                .songId(song.getSongId())
                .songName(song.getSongName())
                .songImageUrl(song.getSongImageUrl())
                .songFileUrl(song.getSongFileUrl())
                .beat(song.getBeat())
                .views(song.getViews())
                .lyricsList(lyricsList)
                .build();
    }
}
