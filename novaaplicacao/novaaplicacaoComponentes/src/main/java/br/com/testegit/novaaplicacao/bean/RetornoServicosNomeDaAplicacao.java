package br.com.testegit.novaaplicacao.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="RetornoServicos")
@XmlAccessorType(XmlAccessType.FIELD)
@Component("retornoServicosNomeDaAplicacao")
public class RetornoServicosNomeDaAplicacao implements Serializable {
	
	private static final long serialVersionUID = -6376460406638624913L;

	private boolean operacaoOK;	
	private long numRetorno;
	private int codErro;
	private String dscErro;
	private String retornoDao;
	
	public RetornoServicosNomeDaAplicacao() {
		super();
		this.operacaoOK = false;
		this.numRetorno = 0;
		this.codErro = 0;
		this.dscErro = "";
		this.retornoDao = "";
	}

	public RetornoServicosNomeDaAplicacao(boolean operacaoOK, long numRetorno, int codErro, String dscErro, String retornoDao) {
		super();
		this.operacaoOK = operacaoOK;
		this.numRetorno = numRetorno;
		this.codErro = codErro;
		this.dscErro = dscErro;
		this.retornoDao = retornoDao;
	}

	public int getCodErro() {
		return codErro;
	}

	public String getDscErro() {
		return dscErro;
	}

	public long getNumRetorno() {
		return numRetorno;
	}

	public boolean isOperacaoOK() {
		return operacaoOK;
	}

	public void setCodErro(int i) {
		codErro = i;
	}

	public void setDscErro(String string) {
		dscErro = string;
	}

	public void setNumRetorno(long l) {
		numRetorno = l;
	}

	public void setOperacaoOK(boolean b) {
		operacaoOK = b;
	}

	public String getRetornoDao() {
		return retornoDao;
	}

	public void setRetornoDao(String retornoDao) {
		this.retornoDao = retornoDao;
	}

}