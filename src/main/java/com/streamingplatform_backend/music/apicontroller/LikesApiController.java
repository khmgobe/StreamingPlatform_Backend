package com.streamingplatform_backend.music.apicontroller;
import com.streamingplatform_backend.music.dto.LikesDto;
import com.streamingplatform_backend.music.entity.Likes;
import com.streamingplatform_backend.music.service.LikesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "/api/musics/likes", description = "좋아요 컨트롤러 API ")
public class LikesApiController {


	private final LikesService likesService;

	@PostMapping("/api/Likes/save")
	public LikesDto save(@RequestBody LikesDto likes){
			return likesService.save(likes);
	}

	@DeleteMapping("/api/Likes/remove")
	public void remove(@RequestBody LikesDto likesDto) {
		 likesService.remove(likesDto);
	}
}
