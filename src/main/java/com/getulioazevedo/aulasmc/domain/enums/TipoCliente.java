package com.getulioazevedo.aulasmc.domain.enums;

public enum TipoCliente {

	PESSOA_FISICA(1, "Pessoa Física"), PESSOA_JURIDICA(2, "Pessoa Juridica");

	private Integer cod;
	private String descricao;

	private TipoCliente(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;

	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer cod) { // variavel do metodo

		if (cod == null) {
			return null;
		}

		for (TipoCliente x : TipoCliente.values()) { 	// Percorre todo tipo Enumerado,buscando valor;
			if (cod.equals(x.getCod())) {  		// Condição que verifica se a varíavel do metodo é igual a valor do Enum.  
				return x;   // Retorna o Valor 1 ou 2;
			}
		}
		
		throw new IllegalArgumentException("Codigo não encontrado " + cod);
	}

}
