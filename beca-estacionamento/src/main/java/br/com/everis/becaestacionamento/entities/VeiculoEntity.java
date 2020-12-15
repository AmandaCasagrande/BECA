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
@Table(name = "veiculos")
public class VeiculoEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVeiculo;
	
	@Column(name = "placa", length = 11, nullable = false, unique = true)
	private String placa;

	@Column(name = "ano")
	private Integer ano;
	
	@Column(name = "cor")
	private String cor;
	
	@ManyToOne
	@JoinColumn(name = "modelo", nullable = true)
	private ModeloVeiculoEntity modelo;
	
	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public ModeloVeiculoEntity getModelo() {
		return modelo;
	}
	
	public void setModelo(ModeloVeiculoEntity modelo) {
		this.modelo = modelo;
	}
	
}
