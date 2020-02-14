package br.com.caelum.ingresso.helper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.caelum.ingresso.dao.TokenDao;
import br.com.caelum.ingresso.model.Token;

@Component
public class TokenHelper {

	@Autowired
	private TokenDao dao;
	
	public Token generateFrom(String email) {
		Token token = new Token(email);
		dao.save(token);
		return token;
	}
	
	public Optional<Token> getTokenFrom(String uuid) {
		return dao.findByUuid(uuid);
	}
}
