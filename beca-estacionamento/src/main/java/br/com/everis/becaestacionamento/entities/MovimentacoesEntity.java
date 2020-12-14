package br.com.everis.becaestacionamento.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "movimentacoes")
@Embeddable
public class MovimentacoesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMovimentacoes;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	@Column(name = "dataEntrada", nullable = false)
	private LocalDateTime dataEntrada;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	@Column(name = "dataSaida")
	private LocalDateTime dataSaida;
	
	@Column(name = "tempoOcupado")
	private Double tempoOcupado;

	@Column(name = "valorTotal")
	private Double valorTotal;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "veiculo")
	private VeiculoEntity veiculo;
	
//	public MovimentacoesEntity(String string) {
//		// Teste
//	}

	public Long getIdMovimentacoes() {
		return idMovimentacoes;
	}

	public void setIdMovimentacoes(Long idMovimentacoes) {
		this.idMovimentacoes = idMovimentacoes;
	}

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}


	public Double getTempoOcupado() {
		return tempoOcupado;
	}

	public void setTempoOcupado(Double tempoOcupado) {
		this.tempoOcupado = tempoOcupado;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public VeiculoEntity getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoEntity veiculo) {
		this.veiculo = veiculo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
