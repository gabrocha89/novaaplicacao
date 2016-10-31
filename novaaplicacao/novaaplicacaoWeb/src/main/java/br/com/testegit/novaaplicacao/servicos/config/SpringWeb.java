package br.com.testegit.novaaplicacao.servicos.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.testegit.novaaplicacao.config.SpringComponentes;

@Configuration
@EnableWebMvc
@ImportResource({"classpath:spring/cxf.xml"})
@Import({WebSecurityConfig.class,SpringComponentes.class})
@ComponentScan(basePackages={"br.com.testegit.novaaplicacao"})

public class SpringWeb {
    
} 