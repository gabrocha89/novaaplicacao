package br.com.testegit.novaaplicacao.servicos.security;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenMissingException extends AuthenticationException {

	private static final long serialVersionUID = 2507064759443770835L;

	public JwtTokenMissingException(String msg) {
        super(msg);
    }
}
