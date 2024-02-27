package com.streamingplatform_backend.music.dto;



import com.streamingplatform_backend.music.apicontroller.MusicPlayListApiController;
import com.streamingplatform_backend.music.entity.Music;
import lombok.Builder;

import java.util.List;

@Builder
public record SimplyMusic(Long music_id) {

	public Music toEntity() {
		return Music.builder()
				.id(music_id).build();
	}


	public static SimplyMusic toBulk(Music music) {
		return SimplyMusic.builder().music_id(music.getId()).build();
	}
}
