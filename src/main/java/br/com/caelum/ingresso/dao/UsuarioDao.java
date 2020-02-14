package br.com.caelum.ingresso.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Usuario;

@Repository
public class UsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	public Optional<Usuario> findByEmail(String email) {
		return manager.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
				.setParameter("email", email).getResultList().stream().findFirst();
	}
	
	public void save(Usuario usuario) {
		if(usuario.getId()==null)
			manager.persist(usuario);
		else
			manager.merge(usuario);
	}
}
