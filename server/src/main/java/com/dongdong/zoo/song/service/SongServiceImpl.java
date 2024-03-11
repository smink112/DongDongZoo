package com.dongdong.zoo.song.service;

import com.dongdong.zoo.song.model.Song;
import com.dongdong.zoo.song.repository.SongRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SongServiceImpl implements SongService{

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }


    // 좋아요, 조회수 내림차순으로 인기 동요 조회
    @Override
    @Transactional
    public List<Song> getSongsByLikesAndViews() {
        return songRepository.findSongsByLikesAndViews();
    }
}
