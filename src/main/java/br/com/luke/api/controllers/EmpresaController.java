package br.com.luke.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luke.api.dto.EmpresaDTO;
import br.com.luke.api.response.Response;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {
	
	/*@PostMapping
	public ResponseEntity<EmpresaDTO> cadastrar(@RequestBody EmpresaDTO empresaDTO){
		empresaDTO.setId(1L);
		return ResponseEntity.ok(empresaDTO);
	}*/
	
	/**
	 * Implementação com o EmpresaDTO encapsulado em um response genérico...
	 * */
	/*@PostMapping
	public ResponseEntity<Response<EmpresaDTO>> cadastrar(@RequestBody EmpresaDTO empresaDTO){
		Response<EmpresaDTO> response = new Response<>();
		
		empresaDTO.setId(1L);
		response.setDados(empresaDTO);
		return ResponseEntity.ok(response);
	}*/
	
	/**
	 * Implementação com o EmpresaDTO com bean validate...
	 * */
	@PostMapping
	public ResponseEntity<Response<EmpresaDTO>> cadastrar(@Valid @RequestBody EmpresaDTO empresaDTO, BindingResult result){
		Response<EmpresaDTO> response = new Response<>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		empresaDTO.setId(1L);
		response.setDados(empresaDTO);
		return ResponseEntity.ok(response);
	}
}
