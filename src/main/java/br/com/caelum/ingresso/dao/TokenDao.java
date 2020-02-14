package br.com.caelum.ingresso.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Token;

@Repository
public class TokenDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void save(Token token) {
		manager.persist(token);
	}
	
	public Optional<Token> findByUuid(String uuid) {
		return manager.createQuery("select t from Token where t.uuid = :uuid" , Token.class)
				.setParameter("uuid", uuid).getResultList().stream().findFirst();
	}
}
