package org.gen.minhaLojaDeGames.model;

import java.util.List;

import javax.persistence.CascadeType;

//import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//anotacoes

@Entity
@Table(name = "categoria")
public class Categoria {
	
	//atributos da categoria 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//chave primaria 
	private long id;
	
	@NotNull
	@Size(min = 5, max = 10)
	private String titulo;
	
	@NotNull
	@Size(min = 5, max = 20)
	private String descricao;
	
	//relacionamento one to many 
		@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
		@JsonIgnoreProperties("categoria")
		private List <Produto> produto;
		

	//getters setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
