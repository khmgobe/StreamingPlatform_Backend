package com.streamingplatform_backend.music.service;

import com.streamingplatform_backend.music.dto.MusicDto;
import com.streamingplatform_backend.music.entity.Music;
import com.streamingplatform_backend.music.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class MusicService {


	private final MusicRepository musicRepository;

	public Music save(Music music) {
		musicRepository.save(music);
		return music;
	}

	public Music update(Music music) {
		music.updateMusic(music);
		return musicRepository.update(music);
	}

	public List<MusicDto> find() {
		List<Music> music = musicRepository.find();
		return music.stream().map(MusicDto::of).toList();
	}

	public MusicDto findById(Long id){
		Music music = musicRepository.findById(id);
		return music.of();
	}

	public Music remove(Long id) {
		Music music = musicRepository.findById(id);
		musicRepository.remove(id);
		return music;
	}

	public void increaseLike(Long id) {
		musicRepository.increaseLike(id);
	}

	public void decreaseLike(Long id) {
		musicRepository.decreaseLike(id);
	}
}
