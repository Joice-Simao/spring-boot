package br.com.gamerstore.minhaLojaDeGames.controller;

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

import br.com.gamerstore.minhaLojaDeGames.repository.CategoriaRepository;
import br.com.gamerstore.minhaLojaDeGames.model.Categoria;
import br.com.gamerstore.minhaLojaDeGames.model.Produto;
import br.com.gamerstore.minhaLojaDeGames.repository.ProdutoRepository;

@RestController
@CrossOrigin (origins = "*", allowedHeaders = "*")
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired 
	private ProdutoRepository repository;
	
	//findAllProduto
	@GetMapping
	public ResponseEntity<List<Produto>>getall(){
		return ResponseEntity.ok(repository.findAll());
	}
	//findByIDProduto
	@GetMapping("/{id}")
	public ResponseEntity<Produto>getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	//findByDescricaoTitulo
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Produto>> getByName(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(titulo));
	}
	//postProduto
	@PostMapping
	public ResponseEntity<Produto> post(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(produto));
	}
	//putCategoria
	@PutMapping
	public ResponseEntity<Produto> put(@RequestBody Produto produto){
		return ResponseEntity.ok(repository.save(produto));
	}
	//deleteCategoria
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}