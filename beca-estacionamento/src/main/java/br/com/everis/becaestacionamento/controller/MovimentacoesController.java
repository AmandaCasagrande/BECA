package br.com.everis.becaestacionamento.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.everis.becaestacionamento.dto.MovimentacoesDTO;
import br.com.everis.becaestacionamento.dto.form.MovimentacoesForm;
import br.com.everis.becaestacionamento.service.MovimentacoesService;

@RestController
@RequestMapping({"/movimentacoes"})
public class MovimentacoesController {
	
	private MovimentacoesService movimentacoesService;
	
	@PostMapping 
	@Transactional
	public ResponseEntity<MovimentacoesDTO> cadastrar(@Valid @RequestBody MovimentacoesForm movimentacoesForm, UriComponentsBuilder uriBuilder){
		
		return movimentacoesService.cadastrar(movimentacoesForm, uriBuilder);
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<MovimentacoesDTO> buscar(@PathVariable long id){

		return movimentacoesService.buscar(id);
	}
	
	
	@PutMapping(path = {"/{id}"})
	public ResponseEntity<MovimentacoesDTO> atualizar(@PathVariable Long id, @Valid @RequestBody MovimentacoesForm movimentacoesForm){

		return movimentacoesService.atualizar(id, movimentacoesForm);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> deletar(@PathVariable Long id) {

		return movimentacoesService.deletar(id);
	}
	
}
