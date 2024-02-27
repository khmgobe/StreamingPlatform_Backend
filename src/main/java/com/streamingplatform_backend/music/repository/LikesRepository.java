package com.streamingplatform_backend.music.repository;

import com.streamingplatform_backend.music.dto.LikesDto;
import com.streamingplatform_backend.music.entity.Likes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LikesRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void save (Likes likes) {
		entityManager.persist(likes);
	}

	 public void remove(LikesDto likesDto) {
		entityManager.createQuery("delete from Likes l where l.id =: id").setParameter("id", likesDto.id()).executeUpdate();
		entityManager.clear();
		entityManager.flush();
	 }

	public List<Likes> findLikesMusicList() {
		return entityManager.createQuery("select l from Likes l join fetch Music m", Likes.class).getResultList();
	}
}
