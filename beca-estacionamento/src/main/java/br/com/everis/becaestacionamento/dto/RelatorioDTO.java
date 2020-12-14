package br.com.everis.becaestacionamento.dto;

import java.util.List;

public class RelatorioDTO {
	
	private Double valorTotal;
	private List<MovimentacoesDTO> movimentacoes;
	private Integer qntdMovimentacoes;
	
	public RelatorioDTO(Double valorTotal, List<MovimentacoesDTO> movimentacoes, Integer qntdMovimentacoes) {
		this.valorTotal = valorTotal;
		this.movimentacoes = movimentacoes;
		this.setQntdMovimentacoes(qntdMovimentacoes);
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<MovimentacoesDTO> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<MovimentacoesDTO> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public Integer getQntdMovimentacoes() {
		return qntdMovimentacoes;
	}

	public void setQntdMovimentacoes(Integer qntdMovimentacoes) {
		this.qntdMovimentacoes = qntdMovimentacoes;
	}

}
