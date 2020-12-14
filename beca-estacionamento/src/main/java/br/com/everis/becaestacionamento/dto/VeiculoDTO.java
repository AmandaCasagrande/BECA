package br.com.everis.becaestacionamento.dto;

import br.com.everis.becaestacionamento.entities.VeiculoEntity;

public class VeiculoDTO {
	
	private Long idVeiculo;
	private String placa;
	private Integer ano;
	private String cor;
	private ModeloVeiculoDTO modelo;
	
	public VeiculoDTO(VeiculoEntity veiculo) {
		this.idVeiculo = veiculo.getIdVeiculo();
		this.placa = veiculo.getPlaca();
		this.ano = veiculo.getAno();
		this.cor = veiculo.getCor();
				
		if (veiculo.getModelo() != null){
			this.modelo = new ModeloVeiculoDTO(veiculo.getModelo());
		}
	}

	public Long getIdVeiculo() {
		return idVeiculo;
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

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public ModeloVeiculoDTO getModelo() {
		return modelo;
	}
	
	public void setModelo(ModeloVeiculoDTO modelo) {
		this.modelo = modelo;
	}
	
}
