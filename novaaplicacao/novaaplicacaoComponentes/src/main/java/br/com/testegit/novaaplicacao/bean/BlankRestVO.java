package br.com.testegit.novaaplicacao.bean;

import org.springframework.stereotype.Component;

@Component("blankRestVO")
public class BlankRestVO {
	
		private String str;		

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}	
		
}