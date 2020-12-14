package br.com.everis.becaestacionamento.service;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.everis.becaestacionamento.dto.MovimentacoesDTO;
import br.com.everis.becaestacionamento.dto.form.GerarMovimentacaoForm;
import br.com.everis.becaestacionamento.entities.MovimentacoesEntity;
import br.com.everis.becaestacionamento.entities.VeiculoEntity;
import br.com.everis.becaestacionamento.repository.ModeloRepository;
import br.com.everis.becaestacionamento.repository.MovimentacoesRepository;
import br.com.everis.becaestacionamento.repository.VeiculoRepository;
import javassist.NotFoundException;

@Service
public class GerarMovimentacaoService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private MovimentacoesRepository movimentacoesRepository;
	
	@Autowired
	private ModeloRepository modeloRepository;

	@Transactional
	public ResponseEntity<MovimentacoesDTO> gerarEntrada(GerarMovimentacaoForm gerarMov,
			UriComponentsBuilder uriBuilder) throws NotFoundException {

		VeiculoEntity veiculo = veiculoRepository.findByPlaca(gerarMov.getPlaca());

		if (veiculo == null) {
			veiculo = new VeiculoEntity();
			veiculo.setPlaca(gerarMov.getPlaca());
			veiculo.setCor(gerarMov.getCor());
			veiculo.setAno(gerarMov.getAno());
			
			if (gerarMov.getIdModelo() != null) {
				veiculo.setModelo(modeloRepository.findById(gerarMov.getIdModelo()).orElse(null));
			}
			
			veiculoRepository.save(veiculo);
		}

		MovimentacoesEntity movimentacoes = new MovimentacoesEntity();
		movimentacoes.setDataEntrada(LocalDateTime.now());
		movimentacoes.setVeiculo(veiculo);
		movimentacoes.setStatus("Aberto");
		movimentacoesRepository.save(movimentacoes);

		URI uri = uriBuilder.path("/movimentacao/{id}").buildAndExpand(movimentacoes.getIdMovimentacoes()).toUri();

		return ResponseEntity.created(uri).body(new MovimentacoesDTO(movimentacoes));
	}

	@Transactional
	public ResponseEntity<MovimentacoesDTO> gerarSaida(GerarMovimentacaoForm gerarMov,
			UriComponentsBuilder uriBuilder) throws NotFoundException {

		VeiculoEntity veiculo = veiculoRepository.findByPlaca(gerarMov.getPlaca());

		if (veiculo == null) {
			throw new NotFoundException("Veiculo não encotrado!");
		}

		MovimentacoesEntity movimentacao = movimentacoesRepository.findByVeiculoAndStatus(veiculo, "Aberto");

		if (movimentacao == null) {
			throw new NotFoundException("Movimentação não encotrada!");
		}

		movimentacao.setStatus("Fechado");
		movimentacao.setDataSaida(LocalDateTime.now());
		
		Double tempoOcupado = Double.valueOf(movimentacao.getDataEntrada().until(movimentacao.getDataSaida(), ChronoUnit.HOURS));
		if (tempoOcupado == 0) {
			tempoOcupado = 1.0;
		}
		movimentacao.setTempoOcupado(tempoOcupado);

		if (movimentacao.getTempoOcupado() <= 1) {
			movimentacao.setValorTotal(Double.valueOf(5));
		} else {
			Double valorTotal = 5.0;
			Double tempo = movimentacao.getTempoOcupado();
			tempo -= 1;
			while (tempo > 0) {
				valorTotal += 2;
				tempo -= 1;
			}
			movimentacao.setValorTotal(valorTotal);
		}

		movimentacoesRepository.save(movimentacao);

		URI uri = uriBuilder.path("/movimentacao/{id}").buildAndExpand(movimentacao.getIdMovimentacoes()).toUri();

		return ResponseEntity.created(uri).body(new MovimentacoesDTO(movimentacao));
	}

}
