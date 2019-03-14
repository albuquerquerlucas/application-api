package br.com.luke.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.luke.api.utils.SenhaUtils;

@SpringBootApplication
public class ApplicationApiApplication {
		
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args ->{
			//System.out.println("### Quantidade de elementos por página = " + this.qtdPorPagina);
			
			testeEncodedSenha();
		};
	}
	
	/**
	 * Teste de encryptação de senha com o BCrypt
	 * do próprio Spring Security
	 * 
	 * */
	public void testeEncodedSenha() {
		String senhaEncoded = SenhaUtils.gerarBCrypt("123456");
		System.out.println("Senha encoded: " + senhaEncoded);
		
		senhaEncoded = SenhaUtils.gerarBCrypt("123456");
		System.out.println("Senha encoded novamente: " + senhaEncoded);
		
		System.out.println("Senha Válida: " + SenhaUtils.senhaValida("123456", senhaEncoded));
	}
}
