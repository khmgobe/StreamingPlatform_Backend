package com.streamingplatform_backend.music.entity;

import com.streamingplatform_backend.music.dto.PlayListDto;
import com.streamingplatform_backend.music.util.StringListConverter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;



@Entity
@Getter
@Builder
@Table(name = "PLAY_LIST")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PlayList {


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "playlist_id")
	private Long id;

	@Column(name = "playlist_name")
	private String name;

	@Column(name = "playlist_memo")
	private String memo;

	@OneToMany
	@JoinColumn(name = "playlist_id")
	private List<Music> music = new ArrayList<>();

	public PlayListDto from() {
		return PlayListDto.builder().id(id).name(name).memo(memo).musicList(music).build();
	}

}
