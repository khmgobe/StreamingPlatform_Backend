package com.streamingplatform_backend.music.apicontroller;

import com.streamingplatform_backend.music.dto.MusicDto;
import com.streamingplatform_backend.music.entity.Music;
import com.streamingplatform_backend.music.service.MusicService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "/api/musics/call", description = "음악 컨트롤러 API ")
@Slf4j
public class MusicApiController {

	private final MusicService musicService;


	@PostMapping(path = "/api/musics/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public Music save(@RequestBody Music musicDto) {
		return musicService.save(musicDto);
	}

	@PatchMapping(path = "/api/musics/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public Music update(@RequestBody Music music) {
		return musicService.update(music);
	}

	@GetMapping(path = "/api/musics/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public MusicDto findById (@PathVariable (name = "id") Long id)  {
		return musicService.findById(id);
	}

	@GetMapping(path = "/api/musics/finds", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MusicDto> find() {
		return musicService.find();
	}

//	@GetMapping(path = "/api/musics/findLikesMusicList", produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<LikesMusicDto> findLikesMusicList() {
//		return musicService.findLikesMusicList();
//	}

	@DeleteMapping(path = "/api/musics/remove/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Music remove (@PathVariable(name = "id") Long id) {
		return musicService.remove(id);
	}

	@PatchMapping(path = "/api/musics/like/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void increaseLike (@PathVariable(name = "id") Long id) {
		 musicService.increaseLike(id);
	}

	@PatchMapping(path = "/api/musics/unlike/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void decreaseLike (@PathVariable(name = "id") Long id) {
		musicService.decreaseLike(id);
	}
}
