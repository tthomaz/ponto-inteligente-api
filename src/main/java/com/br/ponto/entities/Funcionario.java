package com.br.ponto.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

import com.br.ponto.enums.PerfilEnum;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1439106828873438692L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "senha", nullable = false)
	private String senha;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "valor_hora", nullable = true)
	private BigDecimal valorHora;
	
	@Column(name = "qtd_horas_trabalho_dia", nullable = true)
	private Float qtdHorasTrabalhoDia;
	
	@Column(name = "qtd_horas_almoco", nullable = true)
	private Float qtdHorasAloco;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	private PerfilEnum perfil;
	
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;
	
	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Empresa empresa;
	private List<Object> lancamentos;
	
	@Transient
	public Optional<BigDecimal> getQtdValorHoraOpt(){
		return Optional.ofNullable(valorHora);
	}
	
	@Transient
	public Optional<Float> getQtdHorasTrabalhoDiaOpt(){
		return Optional.ofNullable(qtdHorasTrabalhoDia);
	}
	
	@PreUpdate
	private void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	private void prePersist() {
		final Date atual = new Date();
		dataAtualizacao = atual;
		dataCriacao = atual;
	}
	
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha
			   + ", cpf=" + cpf + ", valorHora=" + valorHora + ", qtdHorasTrabalhoDia=" + qtdHorasTrabalhoDia + 
			   ", qtdHorasAloco=" + qtdHorasAloco + ", perfil=" + perfil + ", dataAtualizacao=" + dataAtualizacao + 
			   ", dataCriacao=" + dataCriacao + ", empresa="  + empresa + "]";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public BigDecimal getValorHora() {
		return valorHora;
	}
	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}
	public Float getQtdHorasTrabalhoDia() {
		return qtdHorasTrabalhoDia;
	}
	public void setQtdHorasTrabalhoDia(Float qtdHorasTrabalhoDia) {
		this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
	}
	public Float getQtdHorasAloco() {
		return qtdHorasAloco;
	}
	public void setQtdHorasAloco(Float qtdHorasAloco) {
		this.qtdHorasAloco = qtdHorasAloco;
	}
	public PerfilEnum getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
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
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public List<Object> getLancamentos() {
		return lancamentos;
	}
	public void setLancamentos(List<Object> lancamentos) {
		this.lancamentos = lancamentos;
	}
 }
