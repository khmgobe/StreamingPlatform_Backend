package com.streamingplatform_backend.music.dto;


import com.streamingplatform_backend.music.entity.Likes;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record LikesDto(Long id, SimplyMusic simplyMusic, LocalDateTime create_at) {

	public static LikesDto of(Long id, SimplyMusic simplyMusic) {
		return LikesDto.builder().id(id).create_at(LocalDateTime.now()).
				simplyMusic(simplyMusic).build();
	}


	public Likes toEntity() {
		return Likes.builder()
				 .create_at(LocalDateTime.now())
				.music(simplyMusic.toEntity()).build();
	}

	public LikesDto Response(Likes likes) {
		return LikesDto.builder().id(likes.getId()).simplyMusic(simplyMusic).create_at(create_at()).build();
	}
}
