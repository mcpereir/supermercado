package com.supermercado.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ProdutoDto {

	@NotEmpty
	private Integer codigo;
	@NotBlank
	private String descricao;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
}

