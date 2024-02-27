package com.streamingplatform_backend.music.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "PLAY_LIST")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlayList {


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "playlist_id")
	private Long id;

	@Column(name = "playlist_name")
	private String name;

	@Column(name = "playlist_memo")
	private String memo;

	@OneToMany
	private List<Music> musicList = new ArrayList<>();
}
