package com.br.ponto.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * @author thiago
 *
 */
@Entity
@Table(name = "tb_empresa")
public class Empresa implements Serializable {
	private static final long serialVersionUID = -4146418431260795626L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="razao_social", nullable = false)
	private String razaoSocial;
	private String cnpj;
	@Column(name="data_criacao", nullable = false)
	private Date dataCriacao;
	//@Column(name="data_atualizacao")
	private Date dataAtualizacao;
	@OneToMany(mappedBy = "tb_empresa", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Funcionario> funcionarios;
	
	//contrutor
	public Empresa() {
		
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date dataAtual = new Date();
		dataCriacao = dataAtual;
		dataAtualizacao = dataAtual;
	}
	
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", dataCriacao=" + dataCriacao
			   + ", dataAtualizacao=" + dataAtualizacao + "]";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
}
