package br.com.everis.becaestacionamento.dto;

import br.com.everis.becaestacionamento.entities.MarcaVeiculoEntity;

public class MarcaVeiculoDTO {

	private Long id;
	private String nome;
	
	public MarcaVeiculoDTO(MarcaVeiculoEntity marca) {
		this.id = marca.getId();
		this.nome = marca.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
