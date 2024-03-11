package com.dongdong.zoo.like.model;

import com.dongdong.zoo.song.model.Song;
import com.dongdong.zoo.user.model.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class StoryLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storyLikesId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song_id")
    @JsonManagedReference
    @Setter
    private Song song;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    @Setter
    private User user;
}
