package com.supermercado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity // (name="Item_Cupom")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer qtde;
	private Double valor;
	
	@OneToOne
	@JoinColumn(name="idProduto")
	private Produto produto;
	
	
	@ManyToOne()
	@JoinColumn(name="idCupomFiscal")
	//@JsonBackReference
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private CupomFiscal cupomFiscal;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQtde() {
		return qtde;
	}
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public CupomFiscal getCupomFiscal() {
		return cupomFiscal;
	}
	public void setCupomFiscal(CupomFiscal cupomFiscal) {
		this.cupomFiscal = cupomFiscal;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	

}
