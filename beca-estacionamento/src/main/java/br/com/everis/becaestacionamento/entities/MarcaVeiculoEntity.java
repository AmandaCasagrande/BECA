package br.com.everis.becaestacionamento.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "marca")
public class MarcaVeiculoEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "marca")
	@Column(name = "modelo")
	private List<ModeloVeiculoEntity> modelo;

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

	public List<ModeloVeiculoEntity> getModelo() {
		return modelo;
	}

	public void setModelo(List<ModeloVeiculoEntity> modelo) {
		this.modelo = modelo;
	}

}
