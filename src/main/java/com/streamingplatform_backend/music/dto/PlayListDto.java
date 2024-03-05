package com.streamingplatform_backend.music.dto;

import com.streamingplatform_backend.music.entity.Music;
import com.streamingplatform_backend.music.entity.PlayList;
import lombok.Builder;

import java.util.List;



@Builder
public record PlayListDto (Long id, String name, String memo, List<Music> musicList) {

	public PlayList of() {
		return PlayList.builder().name(name).memo(memo).music(musicList).build();
	}
}
