package com.generation.Farmacia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.Farmacia.Model.CategoriaModel;
import com.generation.Farmacia.Repository.CategoriaRepository;



@RestController
@CrossOrigin(origins = "*", allowedHeaders= "*" )
@RequestMapping("/especificao")

public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	
	}
	
	@GetMapping("/{id}") 
		public ResponseEntity<CategoriaModel> getById(@PathVariable Long id) {
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
	                 .orElse(ResponseEntity.notFound().build());
			
	}
	
	@GetMapping("/especificacao{especificacao}")
	public ResponseEntity<List<CategoriaModel>> getByEspecificacao(@PathVariable String especificacao) {
		return ResponseEntity.ok(repository.findAllByEspecificacaoContainingIgnoreCase(especificacao));
		
	}
	
	@PostMapping
		public ResponseEntity<CategoriaModel> post (@RequestBody CategoriaModel categoria) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(repository.save(categoria));
			
	}
	
	@PutMapping
	public ResponseEntity<CategoriaModel> put (@RequestBody CategoriaModel categoria) {
	    return ResponseEntity.ok(repository.save(categoria));

	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
		
	}
	}
		
	


		
		
		