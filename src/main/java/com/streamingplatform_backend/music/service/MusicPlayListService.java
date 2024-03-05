package com.streamingplatform_backend.music.service;

import com.streamingplatform_backend.music.dto.PlayListDto;
import com.streamingplatform_backend.music.entity.PlayList;
import com.streamingplatform_backend.music.repository.PlayListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicPlayListService {

	private final PlayListRepository playListRepository;

	@Transactional
	public PlayListDto save(PlayListDto playListDto) {
		playListRepository.save(playListDto.of());
		return playListDto;
	}

	@Transactional(readOnly = true)
	public List<PlayListDto> findAll() {
		 return playListRepository.findAll().stream().map(PlayList::from).toList();
	}
}
