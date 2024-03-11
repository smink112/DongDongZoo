package com.dongdong.zoo.song.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;

    // 동요 이름
    private String songName;
    // 동요 썸네일 이미지 경로
    private String songImageUrl;
    // 동요 음원 파일 경로
    private String songFileUrl;
    // 동요 박자 (초 / 가사)
    private Long beat;
    // 조회수
    private Long views;

    // 가사 리스트
    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Lyrics> lyricsList = new ArrayList<>();

}
