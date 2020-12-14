package br.com.everis.becaestacionamento.service;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.everis.becaestacionamento.dto.MovimentacoesDTO;
import br.com.everis.becaestacionamento.dto.form.MovimentacoesForm;
import br.com.everis.becaestacionamento.entities.MovimentacoesEntity;
import br.com.everis.becaestacionamento.repository.MovimentacoesRepository;
import br.com.everis.becaestacionamento.repository.VeiculoRepository;

@Service
public class MovimentacoesService {

	@Autowired
	private MovimentacoesRepository movimentacoesRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	public ResponseEntity<MovimentacoesDTO> cadastrar(@Valid MovimentacoesForm movimentacoesForm,
			UriComponentsBuilder uriBuilder) {
		
		MovimentacoesEntity movimentacoes = new MovimentacoesEntity();
		movimentacoes.setDataEntrada(movimentacoesForm.getDataEntrada());
		movimentacoes.setDataSaida(movimentacoesForm.getDataSaida());
		movimentacoes.setTempoOcupado(movimentacoesForm.getTempoOcupado());
		movimentacoes.setValorTotal(movimentacoesForm.getValorTotal());
		movimentacoes.setVeiculo(veiculoRepository.findById(movimentacoesForm.getIdVeiculo()).orElse(null));
		movimentacoesRepository.save(movimentacoes);
		
		URI uri = uriBuilder.path("/cliente/{id}").
				buildAndExpand(movimentacoes.getIdMovimentacoes()).toUri();
		
		return ResponseEntity.created(uri).body(new MovimentacoesDTO(movimentacoes));
		
	}

	public ResponseEntity<MovimentacoesDTO> buscar(long id) {

		Optional<MovimentacoesEntity> movimentacoes = movimentacoesRepository.findById(id);
		
		if (movimentacoes.isPresent()) {
			return ResponseEntity.ok(new MovimentacoesDTO(movimentacoes.get()));
		}
		
		return ResponseEntity.notFound().build();
		
	}

	public ResponseEntity<MovimentacoesDTO> atualizar(Long id, @Valid MovimentacoesForm movimentacoesForm) {
		Optional<MovimentacoesEntity> movimentacoes = movimentacoesRepository.findById(id);
		
		if (movimentacoes.isPresent()) {
			movimentacoes.get().setDataEntrada(movimentacoesForm.getDataEntrada());
			movimentacoes.get().setDataSaida(movimentacoesForm.getDataSaida());
			movimentacoes.get().setTempoOcupado(movimentacoesForm.getTempoOcupado());
			movimentacoes.get().setValorTotal(movimentacoesForm.getValorTotal());
			movimentacoesRepository.save(movimentacoes.get());
			return ResponseEntity.ok(new MovimentacoesDTO(movimentacoes.get()));
		} 		
	
		return ResponseEntity.notFound().build();
		
	}

	public ResponseEntity<?> deletar(Long id) {
		
		Optional<MovimentacoesEntity> movimentacoes = movimentacoesRepository.findById(id);
		
		if (movimentacoes.isPresent() ) {
			movimentacoesRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();

	}
	
}
