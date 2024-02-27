package com.streamingplatform_backend.music.apicontroller;

import com.streamingplatform_backend.music.dto.PlayListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MusicPlayListApiController {


	@PostMapping(path = "/api/musics/playlist", produces = MediaType.APPLICATION_JSON_VALUE)
	public PlayListDto save(@RequestBody PlayListDto playListDto) {
		return null;
	}
}
