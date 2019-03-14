package br.com.luke.api;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.luke.api.entities.Empresa;
import br.com.luke.api.repositories.EmpresaRepository;
import br.com.luke.api.utils.SenhaUtils;

@SpringBootApplication
public class ApplicationApiApplication {
		
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args ->{
			//System.out.println("### Quantidade de elementos por página = " + this.qtdPorPagina);
			
			//testeEncodedSenha();
			testeEmpresaRepository();
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
	
	/**
	 * Testa as funcionalidades do Banco H2 
	 * */
	public void testeEmpresaRepository() {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Rafael e Rosângela Ferragens ME");
		empresa.setCnpj("78.597.204/0001-49");
		
		this.empresaRepository.save(empresa);
		
		List<Empresa> empresas = empresaRepository.findAll();
		empresas.forEach(System.out::println);
		
		Optional<Empresa> empresaDb = empresaRepository.findById(1L);
		System.out.println("Empresa por ID: " + empresaDb);
		
		if(empresaDb.isPresent()) {
			Empresa e = empresaDb.get();
			e.setRazaoSocial("Ferragens ME");
			this.empresaRepository.save(e);
		}
		
		Empresa empresaCnpj = empresaRepository.findByCnpj("78.597.204/0001-49");
		System.out.println("Empresa por CNPJ: " + empresaCnpj);
		
		this.empresaRepository.deleteById(1L);
		empresas = empresaRepository.findAll();
		System.out.println("Empresas: " + empresas.size());
	}
}
