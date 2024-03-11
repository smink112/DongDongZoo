package com.dongdong.zoo.song.service;

import com.dongdong.zoo.song.model.Song;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SongService {

    // 좋아요, 조회수 내림차순으로 인기 동요 조회
    List<Song> getSongsByLikesAndViews();
}
