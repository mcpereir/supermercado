package com.supermercado.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class CupomFiscal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String cnpj;
	@Column(length = 130)
	private String nomeEstabelecimento;
	private LocalDate data;
	private LocalDateTime hora;
	private Double valorTotal;
	
	@OneToMany(mappedBy = "cupomFiscal",fetch = FetchType.LAZY)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	//@JsonManagedReference 
	//@JsonIgnore
	private List<Item> itens;
	
	
	// ALT+SHIFT+S 
	// SHIFT+R
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}
	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalDateTime getHora() {
		return hora;
	}
	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

}
