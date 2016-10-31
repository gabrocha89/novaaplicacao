package br.com.testegit.novaaplicacao.log;

import org.apache.log4j.Logger;

public class Log4j {

	public static final Logger loggerDebug = Logger.getLogger("debugAuto");
	public static final Logger loggerError = Logger.getLogger("errorAuto");
	public static final Logger loggerAudit = Logger.getLogger("auditAuto");
	public static final Logger loggerCritica = Logger.getLogger("criticaAuto");

	public Log4j() {
		super();
	}

	public static void debug(String descricao) {
		loggerDebug.debug(descricao);
	}

	public static void error(String descricao) {
		loggerError.error(descricao);
	}
	
	public static void error(String descricao, Exception e) {
		loggerError.error(descricao, e);
	}

	public static void audit(String descricao) {
		loggerAudit.debug(descricao);
	}
	
	public static void debug(Exception e) {
		loggerDebug.debug(e);
	}
	public static void error(Exception e) {
		loggerError.error(e);
	}	
	
	public static void debug(Throwable t) {
		loggerDebug.debug(t);
	}
	public static void error(Throwable t) {
		loggerError.error(t);
	}	
	
}
