package br.com.luke.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luke.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	Empresa findByCnpj(String cnpj);
}
