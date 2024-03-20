package com.dongdong.zoo.like.model;

import com.dongdong.zoo.song.model.Song;
import com.dongdong.zoo.user.model.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class SongLikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songLikesId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    @Setter
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song_id")
    @JsonManagedReference
    @Setter
    private Song song;
}
