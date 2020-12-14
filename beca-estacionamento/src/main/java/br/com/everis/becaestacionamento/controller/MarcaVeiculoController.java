package br.com.everis.becaestacionamento.controller;

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

import br.com.everis.becaestacionamento.dto.MarcaVeiculoDTO;
import br.com.everis.becaestacionamento.dto.form.MarcaForm;
//import br.com.everis.becaestacionamento.repository.MarcaRepository;
import br.com.everis.becaestacionamento.service.MarcaVeiculoService;

@RestController
@RequestMapping({"/marca"})
public class MarcaVeiculoController {
	
	@Autowired
	private MarcaVeiculoService marcaService;

/*
	@GetMapping
	public List<MarcaVeiculoDTO> lista (String nomeMarca) {
		Iterable<MarcaVeiculoEntity> findAll = marcaRepository.findAll();

		
		return null;//MarcaVeiculoEntity.converter(marcaRepository.findBy()); 
	}
*/
	@PostMapping
	public ResponseEntity<MarcaVeiculoDTO> cadastrar(@Valid @RequestBody MarcaForm marcaForm, UriComponentsBuilder uriBuilder){

		return marcaService.cadastrar(marcaForm, uriBuilder);
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<MarcaVeiculoDTO> buscar(@PathVariable long id){

		return marcaService.buscar(id);
	}
	
	@PutMapping(path = {"/{id}"})
	public ResponseEntity<MarcaVeiculoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody MarcaForm marcaForm){
		
		return marcaService.atualizar(id, marcaForm);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		
		return marcaService.deletar(id);
	}
	
}
