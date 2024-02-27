package com.streamingplatform_backend.music.dto;

import com.streamingplatform_backend.music.entity.Music;
import com.streamingplatform_backend.music.entity.PlayList;
import lombok.Builder;

import java.util.List;



@Builder
public record PlayListDto (Long id, String name, String memo, List<Music> musicList) {



	public  static List<SimplyMusic> toDtoList(List<Music> musicList) {
		return musicList.stream().map(SimplyMusic::toBulk).toList();
	}

	public PlayListDto response(PlayList playList) {
//		return PlayListDto.builder().name(playList.getName()).memo(playList.getMemo()).musicList(toDtoList(musicList)).build();
		return null;
	}
}
