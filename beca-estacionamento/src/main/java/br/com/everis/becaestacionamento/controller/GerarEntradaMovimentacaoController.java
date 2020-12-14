package br.com.everis.becaestacionamento.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.everis.becaestacionamento.dto.MovimentacoesDTO;
import br.com.everis.becaestacionamento.dto.form.GerarMovimentacaoForm;
import br.com.everis.becaestacionamento.service.GerarMovimentacaoService;
import javassist.NotFoundException;

@RestController
@RequestMapping({"/entradamovimentacoes"})
public class GerarEntradaMovimentacaoController {

	@Autowired
	private GerarMovimentacaoService service;
	
	@PostMapping 
	@Transactional
	public ResponseEntity<MovimentacoesDTO> cadastrar(@Valid @RequestBody GerarMovimentacaoForm movimentacoesForm, UriComponentsBuilder uriBuilder) throws NotFoundException{
		
		return service.gerarEntrada(movimentacoesForm, uriBuilder);
	}
}
