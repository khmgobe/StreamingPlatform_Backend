package com.streamingplatform_backend.music.util;

import lombok.Getter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@Getter
@EnableJpaAuditing
public class BaseEntity {

	private LocalDateTime create_at;

	private LocalDateTime update_at;
}
