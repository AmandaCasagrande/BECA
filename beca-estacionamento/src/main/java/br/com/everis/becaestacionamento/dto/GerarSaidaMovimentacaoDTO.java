package br.com.everis.becaestacionamento.dto;

import java.time.LocalDateTime;

public class GerarSaidaMovimentacaoDTO {

	private VeiculoDTO veiculo;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSaida;
	private Double totalHoras;
	private Double valorPagar;
	private String status;
	
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
	
	public LocalDateTime getHoraSaida() {
		return horaSaida;
	}
	
	public void setHoraSaida(LocalDateTime horaSaida) {
		this.horaSaida = horaSaida;
	}
	
	public Double getTotalHoras() {
		return totalHoras;
	}
	public void setTotalHoras(Double totalHoras) {
		this.totalHoras = totalHoras;
	}
	
	public Double getValorPagar() {
		return valorPagar;
	}
	
	public void setValorPagar(Double valorPagar) {
		this.valorPagar = valorPagar;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}
