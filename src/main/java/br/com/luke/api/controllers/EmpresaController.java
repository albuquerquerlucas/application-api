package br.com.luke.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luke.api.dto.EmpresaDTO;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {
	
	@PostMapping
	public ResponseEntity<EmpresaDTO> cadastrar(@RequestBody EmpresaDTO empresaDTO){
		empresaDTO.setId(1L);
		return ResponseEntity.ok(empresaDTO);
	}
}
