package com.desafio.bossabox.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.bossabox.entities.Ferramenta;
import com.desafio.bossabox.services.FerramentaService;

@RestController
@RequestMapping(value = "/ferramentas")
public class FerramentaResource {
	
	@Autowired
	private FerramentaService ferramentaService;
	
	@GetMapping
	public ResponseEntity<List<Ferramenta>> findAll(){
		List<Ferramenta> listFerramenta = ferramentaService.findAll();
		return ResponseEntity.ok().body(listFerramenta);
	}
	
	@GetMapping(value = "/{tag}")
	public ResponseEntity<List<Ferramenta>> findByTag(@PathVariable String tag){
		List<Ferramenta> listFerramentas = ferramentaService.findByTag(tag);
		return ResponseEntity.ok().body(listFerramentas);
	}
	
	@PostMapping
	public ResponseEntity<Ferramenta> insert(@RequestBody Ferramenta ferramenta){
		ferramenta = ferramentaService.insert(ferramenta);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ferramenta.getId()).toUri();
		return ResponseEntity.created(uri).body(ferramenta);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Ferramenta> delete(@PathVariable Long id){
		ferramentaService.delete(id);
		return ResponseEntity.ok().body(null);
	}
	
	
	
}
