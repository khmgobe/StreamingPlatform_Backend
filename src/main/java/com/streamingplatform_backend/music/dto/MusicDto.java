package com.streamingplatform_backend.music.dto;


import com.streamingplatform_backend.music.entity.Likes;
import com.streamingplatform_backend.music.entity.Music;
import lombok.Builder;
import java.net.URL;
import java.util.List;

@Builder
public record MusicDto(Long id, String title, String artist, String album, String releaseDate, URL image, URL artistPic, List<String> genre, String audioFile) {

	public static MusicDto of(Music music) {
		return MusicDto.builder().
				id(music.getId()).
				title(music.getTitle()).
				artist(music.getArtist()).
				album(music.getAlbum()).
				releaseDate(music.getReleaseDate()).
				image(music.getImage()).
				artistPic(music.getArtistPic()).
				genre(music.getGenre()).
				audioFile(music.getAudioFile()).
				build();
	}
}
