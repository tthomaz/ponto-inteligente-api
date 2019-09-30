package com.br.ponto.services;

import java.util.Optional;

import com.br.ponto.entities.Empresa;

public interface EmpresaService {
	/**
	 * Retorna uma empresa dado um cnpj
	 * @param cnpj
	 * @return Empresa
	 */
	Optional<Empresa> buscaPorCnpj(String cnpj);
	
	/**
	 * Cadastra uma nova empresa na base de dados
	 * @param empresa
	 * @return empresa
	 */
	Empresa persistirEmpresa(Empresa empresa);
}
