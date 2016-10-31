package br.com.testegit.novaaplicacao.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.testegit.novaaplicacao.bean.RetornoServicosNomeDaAplicacao;
import br.com.testegit.novaaplicacao.facade.AbstractFacade;
import br.com.testegit.novaaplicacao.log.Log4j;

@Component("controleBlank")
public class ControleBlank implements IControleBlank {
	
	@Autowired
	private AbstractFacade facade;
	
	public RetornoServicosNomeDaAplicacao someControl(String str) throws Exception {
		
		Log4j.debug("Inicio do metodo: someControl!");

		RetornoServicosNomeDaAplicacao retornoServicos = new RetornoServicosNomeDaAplicacao();
		retornoServicos.setOperacaoOK(false);
		
		String retornoDao = null;
			
		try {			
			retornoDao = facade.someFacade(str);			
			retornoServicos.setOperacaoOK(true);
			retornoServicos.setDscErro("");
			retornoServicos.setRetornoDao(retornoDao);		
		} catch (Exception e){
			retornoServicos.setCodErro(1);
			retornoServicos.setDscErro(e.getMessage());
			Log4j.error(e);
		} catch (Throwable e) {
			retornoServicos.setCodErro(2);
			retornoServicos.setDscErro(e.getMessage());
			Log4j.error(e);
		} 		
		Log4j.debug("Fim do metodo: someControl!");
		return retornoServicos;
	}
	
}
