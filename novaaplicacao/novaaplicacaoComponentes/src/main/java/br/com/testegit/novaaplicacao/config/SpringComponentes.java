package br.com.testegit.novaaplicacao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import br.com.testegit.novaaplicacao.log.Log4j;

@Configuration
@ComponentScan(basePackages = { "br.com.testegit.*" })
public class SpringComponentes {
		
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
		
		//Teste carga do properties de ambiente manualmente.
		System.setProperty("properties.env", "dsv");
		
		String env = System.getProperty("properties.env");
	    
	    Resource resource = new ClassPathResource(env + ".properties");	
	    Log4j.debug(" Resource : " + resource);
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =  new PropertySourcesPlaceholderConfigurer();            
        propertySourcesPlaceholderConfigurer.setLocation(resource);
         
        return propertySourcesPlaceholderConfigurer;
      }    

} 