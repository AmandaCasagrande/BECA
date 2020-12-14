package br.com.everis.becaestacionamento.dto;

import br.com.everis.becaestacionamento.entities.ModeloVeiculoEntity;

public class ModeloVeiculoDTO {
	
	private Long id;
	private String nome;
	private MarcaVeiculoDTO marca;
	
	public ModeloVeiculoDTO(ModeloVeiculoEntity modelo) {
		this.id = modelo.getId();
		this.nome = modelo.getNome();
		this.marca = new MarcaVeiculoDTO(modelo.getMarca());
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public MarcaVeiculoDTO getMarca() {
		return marca;
	} 
	
}
