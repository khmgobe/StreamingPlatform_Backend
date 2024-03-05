package com.streamingplatform_backend.music.apicontroller;

import com.streamingplatform_backend.music.dto.PlayListDto;
import com.streamingplatform_backend.music.service.MusicPlayListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MusicPlayListApiController {

	private final MusicPlayListService playListService;


	@PostMapping(path = "/api/musics/playlist", produces = MediaType.APPLICATION_JSON_VALUE)
	public PlayListDto save(@RequestBody PlayListDto playListDto) {

		 return playListService.save(playListDto);
	}

	@GetMapping(path = "/api/musics/playlist", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PlayListDto> findAll() {
		return playListService.findAll();
	}
}
