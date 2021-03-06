package org.gen.minhaLojaDeGames.repository;

import java.util.List;
import java.util.Optional;

import org.gen.minhaLojaDeGames.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Optional<Usuario> findByUsuario(String usuario);
	//optional pq pode retornar nulo

	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

	public Usuario findByNome(String nome);

}
