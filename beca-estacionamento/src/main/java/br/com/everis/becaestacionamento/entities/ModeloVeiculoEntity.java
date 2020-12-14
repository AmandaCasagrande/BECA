package br.com.everis.becaestacionamento.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MODELOS")
public class ModeloVeiculoEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "marca")
	private MarcaVeiculoEntity marca;

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

	public MarcaVeiculoEntity getMarca() {
		return marca;
	}

	public void setMarca(MarcaVeiculoEntity marca) {
		this.marca = marca;
	}

}
