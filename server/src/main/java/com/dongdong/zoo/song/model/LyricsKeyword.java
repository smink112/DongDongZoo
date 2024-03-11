package com.dongdong.zoo.song.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class LyricsKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lyricsKeywordId;

    //키워드
    private String keyword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lyrics_id")
    @JsonManagedReference
    @Setter
    private Lyrics lyrics;
}
