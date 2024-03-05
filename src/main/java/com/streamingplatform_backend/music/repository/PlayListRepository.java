package com.streamingplatform_backend.music.repository;
import com.streamingplatform_backend.music.entity.PlayList;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayListRepository  {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(PlayList playList) {
		entityManager.persist(playList);
	}

	public List<PlayList> findAll() {
		return entityManager.createQuery("select p from PlayList p join fetch p.music").getResultList();
	}

}
