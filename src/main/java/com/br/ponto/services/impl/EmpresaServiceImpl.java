package com.br.ponto.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ponto.entities.Empresa;
import com.br.ponto.repositories.EmpresaRepository;
import com.br.ponto.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@Override
	public Optional<Empresa> buscaPorCnpj(String cnpj) {
		log.info("Buscando uma empresa por CNPJ {}", cnpj);
		return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
	}

	@Override
	public Empresa persistirEmpresa(Empresa empresa) {
		log.info("Persistindo uma empresa {}", empresa);
		return this.empresaRepository.save(empresa);
	}

}
