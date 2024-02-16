package com.streamingplatform_backend.music.service;

import com.streamingplatform_backend.music.dto.LikesDto;
import com.streamingplatform_backend.music.dto.LikesMusicDto;
import com.streamingplatform_backend.music.dto.MusicDto;
import com.streamingplatform_backend.music.entity.Likes;
import com.streamingplatform_backend.music.repository.LikesRepository;
import com.streamingplatform_backend.music.repository.MusicRepository;
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

	public LikesDto save(Likes likes) {
		Long id = likes.getMusic().getId();
		log.info("id = {} ", id);
		likesRepository.save(likes);
		return LikesDto.builder().build();
	}

	public List<Likes> findLikesMusicList() {
		return likesRepository.findLikesMusicList();
	}

	public LikesDto remove(Long id) {
		likesRepository.remove(id);
		return LikesDto.builder().build();
	}
}
