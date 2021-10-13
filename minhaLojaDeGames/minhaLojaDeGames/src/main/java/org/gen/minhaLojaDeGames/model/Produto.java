package org.gen.minhaLojaDeGames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	//anotacoes
@Entity
@Table(name = "produto")
public class Produto {

	//atributos da categoria 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// chave primaria 
	private long id;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String nome;
	
	@NotNull
	private int preco;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String descricao;
	
	//relacionamento many to one
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;
	
	//getters setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}

