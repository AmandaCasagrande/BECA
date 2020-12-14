package br.com.everis.becaestacionamento.dto.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import br.com.everis.becaestacionamento.entities.VeiculoEntity;

public class VeiculoForm {
	
	@NotEmpty
	@NotBlank
	private String placa;
	private Integer ano;
	private String cor;
	private Long idCliente;
	private Long idModelo;
	
	public VeiculoForm() {
		
	}
	
	public VeiculoForm(VeiculoEntity veiculo) {
		this.placa = veiculo.getPlaca();
		this.ano = veiculo.getAno();
		this.cor = veiculo.getCor();
	}

	public String getPlaca() {
		return placa;
	}

	public Integer getAno() {
		return ano;
	}

	public String getCor() {
		return cor;
	}

	public Long getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	public Long getIdModelo() {
		return idModelo;
	}
	
	public void setIdModelo(Long idModelo) {
		this.idModelo = idModelo;
	}
	
}
