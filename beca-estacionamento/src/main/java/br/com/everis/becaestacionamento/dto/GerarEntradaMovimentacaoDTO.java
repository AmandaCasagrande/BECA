package br.com.everis.becaestacionamento.dto;

import java.time.LocalDateTime;

public class GerarEntradaMovimentacaoDTO {
	
	private String status;
	private VeiculoDTO veiculo;
	private LocalDateTime horaEntrada;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public VeiculoDTO getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(VeiculoDTO veiculo) {
		this.veiculo = veiculo;
	}
	
	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}
	
	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	
}
