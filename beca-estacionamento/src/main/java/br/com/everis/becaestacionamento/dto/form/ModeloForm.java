package br.com.everis.becaestacionamento.dto.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import br.com.everis.becaestacionamento.entities.ModeloVeiculoEntity;

public class ModeloForm {
	
	@NotEmpty
	@NotBlank
	private String nome;
	private Long idMarca;
	
	public ModeloForm() {
		
	}
	
	public ModeloForm(ModeloVeiculoEntity modelo) {
		this.nome = modelo.getNome();
	}

	public String getNome() {
		return nome;
	}

	public Long getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}
	
}
