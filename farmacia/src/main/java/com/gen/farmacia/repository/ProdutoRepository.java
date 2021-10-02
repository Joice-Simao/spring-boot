package com.gen.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gen.farmacia.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long>{
	public List<Produto> findAllByDescricaoContainingIgnoreCase(String descricao);

}
