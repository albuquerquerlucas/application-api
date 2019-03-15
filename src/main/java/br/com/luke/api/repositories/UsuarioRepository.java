package br.com.luke.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.luke.api.entities.Usuario;

@Transactional(readOnly = true)
public interface UsuarioRepository extends BaseRepository<Usuario> {
	public Usuario findByEmail(String email);
}
