package com.streamingplatform_backend.music.entity;

import com.streamingplatform_backend.music.dto.LikesDto;
import com.streamingplatform_backend.music.dto.MusicDto;
import com.streamingplatform_backend.music.util.StringListConverter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@Table(name = "music")
public class Music {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "음악 아이디")
	@Column(name = "music_id")
	private Long id;

	@Schema(description = "음악 제목")
	private String title;

	@Schema(description = "아티스트 이름")
	private String artist;

	@Schema(description = "앨범 이름")
	private String album;

	@Schema(description = "발매일자")
	private String releaseDate;

	@Schema(description = "이미지")
	private URL image;

	@Schema(description = "아티스트")
	private URL artistPic;

	@Schema(description = "카테고리")
	@Convert(converter = StringListConverter.class)
	private List<String> genre;

	@Schema(description = "음악 좋아요")
	private Long likes;

	public void updateMusic(Music music) {
		this.title = music.getTitle();
		this.artist = music.getArtist();
		this.album = music.getAlbum();
		this.releaseDate = music.getReleaseDate();
		this.image = music.getImage();
		this.artistPic = music.getArtistPic();
		this.genre = music.getGenre();
	}

	public MusicDto of() {
		return MusicDto.builder().title(title).build();
	}

	public Music from(MusicDto musicDto) {
		return Music.builder().id(id).title(title).artist(artist).album(album).releaseDate(releaseDate).image(image).artistPic(artistPic).genre(genre).likes(likes).build();
	}

}
