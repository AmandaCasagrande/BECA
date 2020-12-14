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

import br.com.everis.becaestacionamento.dto.RelatorioDTO;
import br.com.everis.becaestacionamento.dto.form.RelatorioForm;
import br.com.everis.becaestacionamento.service.RelatorioService;

@RestController
@RequestMapping({"/relatorio"})
public class RelatorioController {
	
	@Autowired
	private RelatorioService relatorioService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<RelatorioDTO> cadastrar(@Valid @RequestBody RelatorioForm relatorioForm, UriComponentsBuilder uriBuilder){

		return relatorioService.cadastrar(relatorioForm, uriBuilder);
	}

}
