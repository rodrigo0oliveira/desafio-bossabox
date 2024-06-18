package com.desafio.bossabox.repositoriries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafio.bossabox.entities.Ferramenta;

@Repository
public interface FerramentaRepository extends JpaRepository<Ferramenta, Long>{
	
	@Query("SELECT f FROM Ferramenta f WHERE :tag MEMBER OF f.tags")
	public List<Ferramenta> findByTag(@Param("tag") String tag);

}
