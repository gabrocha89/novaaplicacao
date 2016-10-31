package br.com.testegit.novaaplicacao.facade;

import org.springframework.stereotype.Component;

import br.com.testegit.novaaplicacao.log.Log4j;

@Component("facade")
public class Facade extends AbstractFacade {
	
	public String someFacade(String str) throws Exception {
		
		Log4j.debug("Inicio Facade - Metodo: someFacade!");
		
		String retorno =  "$$ Inseri na Tabela e voltei ! $$";
		
		if (retorno.isEmpty()) {
			throw new Exception("Nao foi possivel encontrar registro!");
		}

		Log4j.debug("Fim Facade - Metodo: someFacade!");
		return retorno;
	}
	
}