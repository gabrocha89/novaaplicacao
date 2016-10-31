package br.com.testegit.novaaplicacao.servicos.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;

import br.com.testegit.novaaplicacao.log.Log4j;

/**
 * Validação do token.
 * 
 * <p>
 * Realiza a validação e leitura do token enviado. Caso esteja validado corretamente 
 * (secret OK e tempo de expiração OK), gera um objeto do tipo JwtUserDto com as informações extraídas
 * do token.
 * <p>
 * 
 * @author Gabriel Rocha (G098856)
 * @param token
 * @return Objeto do tipo JwtUserDto
 * @since 28/09/2016
 * 
 */

@Component("jwtTokenUtil")
public class JwtTokenValidator implements Serializable {

    private static final long serialVersionUID = -3301605591108950415L;
  
    @Value("${jwt.secret}")
    private String secret;
    
    public JwtUserDto validaToken(String token) throws XmlMappingException {
    	
        Log4j.debug("### JwtTokenValidator - validaToken");
        
        JwtUserDto u = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            u = new JwtUserDto();
            u.setUsuario(body.getSubject());
            long horaCriadoToken = (Long) body.get("created");
            Date dtCriadoToken = new Date (horaCriadoToken);             
            u.setDataCriacao(dtCriadoToken);
            u.setExpiration(body.getExpiration());
            u.setRole((String) body.get("role"));  
            u.setCodProdutor((int) body.get("codProdutor"));  
            u.setPermiteRenovacao((String) body.get("permiteRenovacao"));  
            u.setEnvioProposta((String) body.get("envioProposta"));  
            u.setEnvioEndosso((String) body.get("envioEndosso"));  
            u.setAutorizacao((String) body.get("autorizacao"));  
            u.setUsuarioPLP((String) body.get("usuarioPLP"));              
           
            //Algoritmo para extração da lista de funcionalidades, caso seja necessário futuramente.
         /* Collection<Integer> codFuncionalidade = new TreeSet<Integer>();
            String funcionalidades = body.get("perfil").toString();          
            String codigo= funcionalidades;
            String temp = codigo.substring(codigo.indexOf("[")+1,codigo.indexOf("]"));
            String[] a2 = temp.split(", ");            
            for (int i=0; i<a2.length; i++) {
                codFuncionalidade.add(Integer.parseInt(a2[i]));
            }            
            ListaFuncionalidades lista = new ListaFuncionalidades();
            lista.setCodFuncionalidade(codFuncionalidade);
            u.setFuncionalidades(lista); */

        } catch (JwtException e) {
        	Log4j.error(e);
        	String retorno = e.toString();
        	String buscaExpirado = "expired";
        	String buscaInvalido = "unable to read";
        	if (retorno.toLowerCase().contains(buscaExpirado.toLowerCase())) {
        		Log4j.debug(" AUTENTICACAO - Token expirado.");
        	}
        	if (retorno.toLowerCase().contains(buscaInvalido.toLowerCase())) {
        		Log4j.debug(" AUTENTICACAO - O Token esta gerado incorretamente.");
        	}
        }
        return u;
    }
    
}