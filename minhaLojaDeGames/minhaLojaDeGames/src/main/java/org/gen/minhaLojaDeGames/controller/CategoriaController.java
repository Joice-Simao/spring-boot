package org.gen.minhaLojaDeGames.controller;

import java.util.List;

import org.gen.minhaLojaDeGames.model.Categoria;
import org.gen.minhaLojaDeGames.repository.CategoriaRepository;
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


//anotacoes
@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>>GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	//findByIDCategoria
	@GetMapping("/{id}")
	public ResponseEntity<Categoria>getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	//findByIDescricao
	@GetMapping ("/descricao/{descricao}")//repete 2x para nao confundir a rota 
	public ResponseEntity<List<Categoria>>getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));//verificar se esta certo
	}
	//postCategoria
	@PostMapping 
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(categoria));
	}
	//putCategoria
	@PutMapping 
	public ResponseEntity<Categoria> put(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(categoria));
	}
	//deleteCategoria
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
