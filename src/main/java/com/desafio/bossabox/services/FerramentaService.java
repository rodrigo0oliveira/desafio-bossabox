package com.desafio.bossabox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.bossabox.entities.Ferramenta;
import com.desafio.bossabox.repositoriries.FerramentaRepository;

@Service
public class FerramentaService {
	
	@Autowired
	private FerramentaRepository ferramentaRepository;
	
	public List<Ferramenta> findAll(){
		return ferramentaRepository.findAll();
	}
	
	public List<Ferramenta> findByTag(String tag){
		return ferramentaRepository.findByTag(tag);
	}
	
	public Ferramenta insert(Ferramenta ferramenta) {
		return ferramentaRepository.save(ferramenta);
	}
	
	public void delete(Long id) {
		ferramentaRepository.deleteById(id);
	}

}
