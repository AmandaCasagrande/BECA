package br.com.everis.becaestacionamento.dto.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import br.com.everis.becaestacionamento.entities.MarcaVeiculoEntity;

public class MarcaForm {
	
	@NotBlank
	@NotEmpty
	private String nome;
	
	public MarcaForm() {
		
	}
	
	public MarcaForm(MarcaVeiculoEntity marca) {
		this.nome = marca.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
