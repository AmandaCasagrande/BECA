package br.com.everis.becaestacionamento.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.everis.becaestacionamento.dto.MovimentacoesDTO;
import br.com.everis.becaestacionamento.dto.RelatorioDTO;
import br.com.everis.becaestacionamento.dto.form.RelatorioForm;
import br.com.everis.becaestacionamento.entities.MovimentacoesEntity;
import br.com.everis.becaestacionamento.repository.MovimentacoesRepository;

@Service
public class RelatorioService {
	
	@Autowired
	private MovimentacoesRepository movimentacoesRepository;

	public ResponseEntity<RelatorioDTO> cadastrar(@Valid RelatorioForm relatorioForm,
			UriComponentsBuilder uriBuilder) {
		
		List<MovimentacoesEntity> listaMovPeriodo = movimentacoesRepository.
				findByDataSaidaBetweenAndStatus(
				relatorioForm.getDataInicio(), 
				relatorioForm.getDataFim(), 
				"Fechado");
		
		Double valorTotal = 0.0;
		Integer qntdMovimentacoes = 0;
		List<MovimentacoesDTO> listDto = new ArrayList<>();
		
		for (MovimentacoesEntity movimentacoesEntity : listaMovPeriodo) {
			qntdMovimentacoes = qntdMovimentacoes + 1;
			valorTotal = valorTotal + movimentacoesEntity.getValorTotal();
			listDto.add(new MovimentacoesDTO(movimentacoesEntity));
		}
		
		URI uri = uriBuilder.path("/relatorio").buildAndExpand().toUri();
		
		return ResponseEntity.created(uri).body(new RelatorioDTO(valorTotal, listDto, qntdMovimentacoes));
	}
}
