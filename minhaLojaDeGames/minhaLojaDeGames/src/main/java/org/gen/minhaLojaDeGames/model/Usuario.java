package org.gen.minhaLojaDeGames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Nome nao pode estar vazio")
	@Size(min = 2, max = 100, message = "Minimo 2 caracteres, maximo 100 caracteres")
	private String nome;
	
	@NotNull(message = "Usuario nao pode estar vazio")
	@Size(min = 5, max = 100, message = "Minimo 5 caracteres, maximo 100 caracteres")
	private String usuario;
	
	@NotNull(message = "Senha nao pode estar vazio")
	@Size(min = 5, max = 100, message = "Minimo 5 caracteres, maximo 100 caracteres")
	private String senha;

	//relacionamento
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Produto> produto;
	
	public Usuario(long id, String nome, String usuario, String senha) {
		
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		
	}
	//construtor vazio
	public Usuario() {}
	
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Produto> getProduto() {
		return produto;
	}
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
		
}
