package com.streamingplatform_backend.music.entity;

import com.streamingplatform_backend.music.util.StringListConverter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.net.URL;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@Table(name = "music")
public class Music {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "음악 아이디", hidden = true)
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
	private List<String> category;

	public void updateMusic(Music music) {
		this.title = music.getTitle();
		this.artist = music.getArtist();
		this.album = music.getAlbum();
		this.releaseDate = music.getReleaseDate();
		this.image = music.getImage();
		this.artistPic = music.getArtistPic();
	}
}
