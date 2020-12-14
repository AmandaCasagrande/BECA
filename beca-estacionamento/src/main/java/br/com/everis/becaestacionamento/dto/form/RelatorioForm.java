package br.com.everis.becaestacionamento.dto.form;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RelatorioForm {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime dataInicio;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime dataFim;
	
	public LocalDateTime getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public LocalDateTime getDataFim() {
		return dataFim;
	}
	
	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}
	
}
