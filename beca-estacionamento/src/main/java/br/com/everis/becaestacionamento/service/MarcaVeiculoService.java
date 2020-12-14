package br.com.everis.becaestacionamento.service;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.everis.becaestacionamento.dto.MarcaVeiculoDTO;
import br.com.everis.becaestacionamento.dto.form.MarcaForm;
import br.com.everis.becaestacionamento.entities.MarcaVeiculoEntity;
import br.com.everis.becaestacionamento.repository.MarcaRepository;

@Service
public class MarcaVeiculoService {
	
	@Autowired
	private MarcaRepository marcaRepository;

	public ResponseEntity<MarcaVeiculoDTO> cadastrar(@Valid MarcaForm marcaForm, UriComponentsBuilder uriBuilder) {

		MarcaVeiculoEntity marca = new MarcaVeiculoEntity();
		marca.setNome(marcaForm.getNome());
		marcaRepository.save(marca);
		
		URI uri = uriBuilder.path("/marca/{id}").
				buildAndExpand(marca.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new MarcaVeiculoDTO(marca));
	}

	public ResponseEntity<MarcaVeiculoDTO> buscar(long id) {
		Optional<MarcaVeiculoEntity> marca = marcaRepository.findById(id);
		
		if (marca.isPresent()) {
			return ResponseEntity.ok(new MarcaVeiculoDTO(marca.get()));
		}
		
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<MarcaVeiculoDTO> atualizar(Long id, @Valid MarcaForm marcaForm) {
		Optional<MarcaVeiculoEntity> marca = marcaRepository.findById(id);
		
		if (marca.isPresent()) {
			marca.get().setNome(marcaForm.getNome());
			marcaRepository.save(marca.get());
			return ResponseEntity.ok(new MarcaVeiculoDTO(marca.get()));
		} 		
	
		return ResponseEntity.notFound().build();		
	}

	public ResponseEntity<?> deletar(Long id) {
		Optional<MarcaVeiculoEntity> marca = marcaRepository.findById(id);
		
		if (marca.isPresent() ) {
			marcaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
		
}
