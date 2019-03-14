package br.com.luke.api.repositories;

import org.springframework.stereotype.Repository;

import br.com.luke.api.entities.Empresa;

@Repository("EmpresaRepository")
public interface EmpresaRepository extends BaseRepository<Empresa> {
	
	public Empresa findByCnpj(String cnpj);
}
