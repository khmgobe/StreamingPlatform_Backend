package com.streamingplatform_backend.music.service;

import com.streamingplatform_backend.music.dto.LikesDto;
import com.streamingplatform_backend.music.entity.Likes;
import com.streamingplatform_backend.music.repository.LikesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class LikesService {

	private final LikesRepository likesRepository;

	private final MusicService musicService;

	public LikesDto save(LikesDto likesDto) {
		likesRepository.save(likesDto.toEntity());
		musicService.increaseLike(likesDto.simplyMusic().music_id());
		return LikesDto.of(likesDto.toEntity().getId(), likesDto.simplyMusic());
	}

	public List<Likes> findLikesMusicList() {
		return likesRepository.findLikesMusicList();
	}

	public void remove(LikesDto likesDto) {
		likesRepository.remove(likesDto);
		musicService.decreaseLike(likesDto.simplyMusic().music_id());
	}
}
