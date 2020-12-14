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

import br.com.everis.becaestacionamento.dto.ModeloVeiculoDTO;
import br.com.everis.becaestacionamento.dto.form.ModeloForm;
import br.com.everis.becaestacionamento.service.ModeloVeiculoService;

@RestController
@RequestMapping({"/modelo"})
public class ModeloController {
	
	@Autowired
	private ModeloVeiculoService modeloService;

	@PostMapping
	@Transactional
	public ResponseEntity<ModeloVeiculoDTO> cadastrar(@Valid @RequestBody ModeloForm modeloForm, UriComponentsBuilder uriBuilder){
		
		return modeloService.cadastrar(modeloForm, uriBuilder);
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<ModeloVeiculoDTO> buscar(@PathVariable long id){

		return modeloService.buscar(id);
	}
	
	
	@PutMapping(path = {"/{id}"})
	public ResponseEntity<ModeloVeiculoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ModeloForm modeloForm){
		
		return modeloService.atualizar(id, modeloForm);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		
		return modeloService.deletar(id);
	}
	
}
