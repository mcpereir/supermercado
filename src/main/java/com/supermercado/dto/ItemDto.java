package com.supermercado.dto;

import javax.validation.constraints.NotBlank;

public class ItemDto {

	@NotBlank
	private Integer qtde;
	@NotBlank
	private Double valor;
	
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

	
	
}

