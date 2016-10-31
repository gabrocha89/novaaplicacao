package br.com.testegit.novaaplicacao.servicos.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.testegit.novaaplicacao.bean.RetornoServicosNomeDaAplicacao;

@WebService
public interface BlankSoap {

	@WebMethod
	public RetornoServicosNomeDaAplicacao someMethod(@WebParam(name="chassi") String str) throws Exception;
}
