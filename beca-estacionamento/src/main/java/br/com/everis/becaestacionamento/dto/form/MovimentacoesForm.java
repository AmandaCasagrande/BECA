package br.com.everis.becaestacionamento.dto.form;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.everis.becaestacionamento.entities.MovimentacoesEntity;

public class MovimentacoesForm {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime dataEntrada;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime dataSaida;
	private Double tempoOcupado;
	private Double valorTotal;
	private Long idCliente;
	private Long idVeiculo;

	public MovimentacoesForm(MovimentacoesEntity movimentacoes) {
		this.dataEntrada = movimentacoes.getDataEntrada();
		this.dataSaida = movimentacoes.getDataSaida();
		this.tempoOcupado= movimentacoes.getTempoOcupado();
		this.valorTotal = movimentacoes.getValorTotal();
	}
	
	public MovimentacoesForm() {
		
	}

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public Double getTempoOcupado() {
		return tempoOcupado;
	}

	public Double getValorTotal() {
		return valorTotal;
	}
	
	public Long getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	public Long getIdVeiculo() {
		return idVeiculo;
	}
	
	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	
}
