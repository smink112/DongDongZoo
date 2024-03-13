package com.dongdong.zoo.song.controller;

import com.dongdong.zoo.song.dto.SongDetailResponse;
import com.dongdong.zoo.song.dto.SongListResponse;
import com.dongdong.zoo.song.model.Song;
import com.dongdong.zoo.song.service.SongService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<List<SongListResponse>> getSongsByLikesAndViews(){
        return new ResponseEntity<>(songService.getSongsByLikesAndViews(), HttpStatus.OK);
    }

    // 동요 상세 조회
    @GetMapping("/{songId}")
    public ResponseEntity<SongDetailResponse> getSongBySongId(@PathVariable Long songId){
        return new ResponseEntity<>(songService.getSongBySongId(songId), HttpStatus.OK);
    }

}
