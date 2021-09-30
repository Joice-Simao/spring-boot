package br.com.gamerstore.minhaLojaDeGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gamerstore.minhaLojaDeGames.model.Categoria;
import br.com.gamerstore.minhaLojaDeGames.model.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{
	public List <Produto>findAllByDescricaoContainingIgnoreCase(String descricao);
}
