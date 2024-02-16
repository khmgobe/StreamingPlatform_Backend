package com.streamingplatform_backend.music.dto;


import com.streamingplatform_backend.music.entity.Likes;
import com.streamingplatform_backend.music.entity.Music;
import lombok.Builder;
import lombok.Getter;

@Builder
public record LikesDto(Long id, Boolean likes) {

	public static LikesDto of(Music music) {
		return LikesDto.builder().build();
	}
}
