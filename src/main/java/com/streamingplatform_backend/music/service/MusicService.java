package com.streamingplatform_backend.music.service;

import com.streamingplatform_backend.music.entity.Music;
import com.streamingplatform_backend.music.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
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

	public List<Music> find() {
		return musicRepository.find();
	}

	public Music findById(Long id){
		Music music = musicRepository.findById(id);
		return music;
	}

	public Music remove(Long id) {
		Music music = musicRepository.findById(id);
		musicRepository.remove(id);
		return music;
	}
}
