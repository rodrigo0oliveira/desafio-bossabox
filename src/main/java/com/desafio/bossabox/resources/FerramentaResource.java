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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/tools",produces = {"application/json"})
@Tag(name = "api")
public class FerramentaResource {
	
	@Autowired
	private FerramentaService ferramentaService;
	
	@GetMapping
	@Operation(summary = "Retorna todos as ferramentas registradas",method = "GET")
	public ResponseEntity<List<Ferramenta>> findAll(){
		List<Ferramenta> listFerramenta = ferramentaService.findAll();
		return ResponseEntity.ok().body(listFerramenta);
	}
	
	@GetMapping(value = "/{tag}")
	@Operation(summary = "Retorna uma lista de ferramentas que contém determinada tag",method = "GET")
	public ResponseEntity<List<Ferramenta>> findByTag(@PathVariable String tag){
		List<Ferramenta> listFerramentas = ferramentaService.findByTag(tag);
		return ResponseEntity.ok().body(listFerramentas);
	}
	
	@PostMapping
	@Operation(summary = "Inseri uma nova ferramenta",method = "POST")
	public ResponseEntity<Ferramenta> insert(@RequestBody Ferramenta ferramenta){
		ferramenta = ferramentaService.insert(ferramenta);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ferramenta.getId()).toUri();
		return ResponseEntity.created(uri).body(ferramenta);
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Deleta uma ferramenta por id",method = "DELETE")
	public ResponseEntity<Ferramenta> delete(@PathVariable Long id){
		ferramentaService.delete(id);
		return ResponseEntity.ok().body(null);
	}
	
	
	
}
