package br.com.everis.becaestacionamento.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.everis.becaestacionamento.dto.VeiculoDTO;
import br.com.everis.becaestacionamento.dto.form.VeiculoForm;
import br.com.everis.becaestacionamento.service.VeiculoService;

@RestController
@RequestMapping({"/veiculos"})
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<VeiculoDTO> cadastrar(@Valid @RequestBody VeiculoForm veiculoForm, UriComponentsBuilder uriBuilder){

		return veiculoService.cadastrar(veiculoForm, uriBuilder);
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<VeiculoDTO> buscar(@PathVariable long id){
		
		return veiculoService.buscar(id);
	}
	
	@PutMapping(path = {"/{id}"})
	public ResponseEntity<VeiculoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody VeiculoForm veiculoForm){
		
		return veiculoService.atualizar(id, veiculoForm);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		
		return veiculoService.deletar(id);
	}
	
}
