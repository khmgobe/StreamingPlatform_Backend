package com.streamingplatform_backend.music.service;

import com.streamingplatform_backend.music.dto.LikesMusicDto;
import com.streamingplatform_backend.music.dto.MusicDto;
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

	public List<MusicDto> find() {
		List<Music> music = musicRepository.find();
		return music.stream().map(MusicDto::of).toList();
	}

	public List<LikesMusicDto> findLikesMusicList() {
//		List<Music> music = musicRepository.findLikesMusicList();
//		 return music.stream().map(LikesMusicDto::of).toList();
		return null;
	}

	public MusicDto findById(Long id){
		Music music = musicRepository.findById(id);
		return music.of(music);
	}

	public Music remove(Long id) {
		Music music = musicRepository.findById(id);
		musicRepository.remove(id);
		return music;
	}
}
