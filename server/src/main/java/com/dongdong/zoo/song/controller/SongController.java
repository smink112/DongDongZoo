package com.dongdong.zoo.song.controller;

import com.dongdong.zoo.song.model.Song;
import com.dongdong.zoo.song.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/songs")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Songs", description = "Song API")
public class SongController {

    private final SongService songService;

    // 좋아요, 조회수 내림차순으로 인기 동요 조회
    @GetMapping
    public ResponseEntity<List<Song>> getSongsByLikesAndViews(){
        return new ResponseEntity<>(songService.getSongsByLikesAndViews(), HttpStatus.OK);
    }

}
