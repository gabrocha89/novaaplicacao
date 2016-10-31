package br.com.testegit.novaaplicacao.servicos.soap;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.testegit.novaaplicacao.bean.RetornoServicosNomeDaAplicacao;
import br.com.testegit.novaaplicacao.controle.IControleBlank;
import br.com.testegit.novaaplicacao.log.Log4j;
import br.com.testegit.novaaplicacao.servicos.security.AuthenticatedUser;

@WebService
public class BlankSoapImpl extends SpringBeanAutowiringSupport implements BlankSoap {

	@Autowired
	private IControleBlank controleBlank;
	
	public RetornoServicosNomeDaAplicacao someMethod(String str) throws Exception {
		
		Log4j.debug("# Entrada BlankSoap - Metodo: someMethodBlank");
		
		RetornoServicosNomeDaAplicacao retornoServicos = null;
		
		//As duas linhas abaixo sao para geracao do Objeto do JWT(Token) e extracao das suas informacoes, caso necessario.
		AuthenticatedUser userLogged = (AuthenticatedUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String usuario = userLogged.getUsername();	
		
		try {
			retornoServicos = controleBlank.someControl(str);
		} catch (Exception e){
			Log4j.error(e.toString(), e);
			throw e;
		} 	
		Log4j.debug("# Saida BlankSoap - Metodo: someMethodBlank");
		return retornoServicos;  
	}
}
