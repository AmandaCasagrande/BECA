package br.com.everis.becaestacionamento.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.everis.becaestacionamento.entities.MovimentacoesEntity;

public class MovimentacoesDTO {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime dataEntrada;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime dataSaida;

	private Double tempoOcupado;
	private Double valorTotal;
	private VeiculoDTO veiculo;
	
	public MovimentacoesDTO(MovimentacoesEntity movimentacoes) {
		this.dataEntrada = movimentacoes.getDataEntrada();
		this.dataSaida = movimentacoes.getDataSaida();
		this.tempoOcupado = movimentacoes.getTempoOcupado();
		this.valorTotal = movimentacoes.getValorTotal();
	
		if(movimentacoes.getVeiculo() != null) {
			this.veiculo = new VeiculoDTO(movimentacoes.getVeiculo());			
		}
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

	public VeiculoDTO getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoDTO veiculo) {
		this.veiculo = veiculo;
	}
	
	
	
}
