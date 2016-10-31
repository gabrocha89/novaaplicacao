package br.com.testegit.novaaplicacao.servicos.security;

import java.util.Date;

public class JwtUserDto {

    private String usuario;
    private Date dataCriacao;
    private Date expiration;
    private String role;
	private long codProdutor;
	private String permiteRenovacao;
	private String envioProposta;
	private String envioEndosso;
	private String autorizacao;
	private String usuarioPLP;


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    public long getCodProdutor() {
		return codProdutor;
	}

	public void setCodProdutor(long codProdutor) {
		this.codProdutor = codProdutor;
	}

	public String getPermiteRenovacao() {
		return permiteRenovacao;
	}

	public void setPermiteRenovacao(String permiteRenovacao) {
		this.permiteRenovacao = permiteRenovacao;
	}

	public String getEnvioProposta() {
		return envioProposta;
	}

	public void setEnvioProposta(String envioProposta) {
		this.envioProposta = envioProposta;
	}

	public String getEnvioEndosso() {
		return envioEndosso;
	}

	public void setEnvioEndosso(String envioEndosso) {
		this.envioEndosso = envioEndosso;
	}

	public String getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}

	public String getUsuarioPLP() {
		return usuarioPLP;
	}

	public void setUsuarioPLP(String usuarioPLP) {
		this.usuarioPLP = usuarioPLP;
	}

	public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

	
}