package br.com.testegit.novaaplicacao.servicos.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AuthenticatedUser implements UserDetails {

	private static final long serialVersionUID = -9220112730066108357L;

    private final String username;
    private final String token;
    private final Collection<? extends GrantedAuthority> authorities;
	private final long codProdutor;
	private final String permiteRenovacao;
	private final String envioProposta;
	private final String envioEndosso;
	private final String autorizacao;
	private final String usuarioPLP;

    public AuthenticatedUser(String username, String token, Collection<? extends GrantedAuthority> authorities, long codProdutor, String permiteRenovacao,
    					     String envioProposta, String envioEndosso, String autorizacao, String usuarioPLP) {     
        this.username = username;
        this.token = token;
        this.authorities = authorities;
        this.codProdutor = codProdutor;
        this.permiteRenovacao = permiteRenovacao;
        this.envioProposta = envioProposta;
        this.envioEndosso = envioEndosso;
        this.autorizacao = autorizacao;
        this.usuarioPLP = usuarioPLP;        
    }

    public String getUsername() {
        return username;
    }

    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public String getToken() {
        return token;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return null;
    }
    
    public long getCodProdutor() {
        return codProdutor;
    }

    public String getPermiteRenovacao() {
        return permiteRenovacao;
    }
    
    public String getEnvioProposta() {
        return envioProposta;
    }
    
    public String getEnvioEndosso() {
        return envioEndosso;
    }
    
    public String getAutorizacao() {
        return autorizacao;
    }
    
    public String getUsuarioPLP() {
        return usuarioPLP;
    }
}
