package br.com.testegit.novaaplicacao.servicos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.testegit.novaaplicacao.bean.BlankRestVO;
import br.com.testegit.novaaplicacao.bean.RetornoServicosNomeDaAplicacao;
import br.com.testegit.novaaplicacao.controle.IControleBlank;
import br.com.testegit.novaaplicacao.log.Log4j;
import br.com.testegit.novaaplicacao.servicos.security.AuthenticatedUser;

@RestController
@RequestMapping("blankrest")
public class BlankRest {

	@Autowired
	private IControleBlank controleBlank;
	
	@RequestMapping(value = "/somemethodblank",method = RequestMethod.POST, produces = "application/json")
	public RetornoServicosNomeDaAplicacao someMethodBlank(@RequestBody BlankRestVO blankRestVO) {
		
		Log4j.debug("# Entrei BlankRest teste - Metodo: someMethodBlank");
		
		RetornoServicosNomeDaAplicacao retornoServicos = null;
		
		//As duas linhas abaixo sao para geracao do Objeto do JWT(Token) e extracao das suas informacoes, caso necessario.
		AuthenticatedUser userLogged = (AuthenticatedUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String usuario = userLogged.getUsername();	
		
		try {			
			retornoServicos = controleBlank.someControl(blankRestVO.getStr());			
		} catch (Exception e) {
			Log4j.error(e.toString());
			retornoServicos.setCodErro(1);
			retornoServicos.setDscErro(e.getMessage());
			retornoServicos.setOperacaoOK(false);
		} 	
		Log4j.debug("# Fim BlankRest - Metodo: someMethodBlank #");
		return retornoServicos;
	}
}
