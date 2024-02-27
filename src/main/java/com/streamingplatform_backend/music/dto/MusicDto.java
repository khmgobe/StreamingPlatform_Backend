package com.streamingplatform_backend.music.dto;



import com.streamingplatform_backend.music.entity.Music;
import lombok.Builder;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Builder
public record MusicDto(Long id, String title, String artist, String album, String releaseDate, URL image, URL artistPic, List<String> genre, Long likes) {

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
						likes(music.getLikes()).
						build();
	}

	public static List<MusicDto> EntityToDto(List<Music> musicList) {
		return musicList.stream().map(MusicDto::of).collect(Collectors.toList());
	}


	/**
	 * 엔티티 리스트를 아이디값을 이용해서 리스트로 치환합니다.
	 * @param musicList
	 * @return
	 */
	public static List<Long> bindingLongList(List<Music> musicList) {
		return musicList.stream().mapToLong(Music::getId).boxed().toList();
	}
}
