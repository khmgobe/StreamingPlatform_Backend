package com.streamingplatform_backend.music.repository;

import com.streamingplatform_backend.music.entity.Music;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusicRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Music music) {
		 entityManager.persist(music);
	}

	public Music update(Music music) {
		return entityManager.merge(music);
	}

	public Music findById(Long id) {
		return entityManager.find(Music.class, id);
	}


	public List<Music> find() {
		return entityManager.createQuery("select m from Music m", Music.class).getResultList();
	}

	public void remove(Long id) {
		 entityManager.createQuery("delete from Music m where m.id =:id").setParameter("id", id).executeUpdate();
		 entityManager.flush();
		 entityManager.clear();
	}

}
