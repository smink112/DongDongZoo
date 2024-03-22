package com.dongdong.zoo.like.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LikeRequest {

    @NotNull
    Long userId;

    Long songId;

    Long boardId;

    @AssertTrue
    public boolean checkSongId(LikeRequest likeRequest) {return likeRequest.songId != null;}
    @AssertTrue
    public boolean checkBoardId(LikeRequest likeRequest) {return likeRequest.boardId != null;}
}
