package br.com.everis.becaestacionamento.service;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.everis.becaestacionamento.dto.ModeloVeiculoDTO;
import br.com.everis.becaestacionamento.dto.form.ModeloForm;
import br.com.everis.becaestacionamento.entities.ModeloVeiculoEntity;
import br.com.everis.becaestacionamento.repository.MarcaRepository;
import br.com.everis.becaestacionamento.repository.ModeloRepository;

@Service
public class ModeloVeiculoService {
	
	@Autowired
	private ModeloRepository modeloRepository;
	
	@Autowired
	private MarcaRepository marcaRepository;

	public ResponseEntity<ModeloVeiculoDTO> buscar(long id) {
		
		Optional<ModeloVeiculoEntity> modelo = modeloRepository.findById(id);
		
		if (modelo.isPresent()) {
			return ResponseEntity.ok(new ModeloVeiculoDTO(modelo.get()));
		}
		
		return ResponseEntity.notFound().build();

	}

	public ResponseEntity<ModeloVeiculoDTO> cadastrar(@Valid ModeloForm modeloForm, UriComponentsBuilder uriBuilder) {
		ModeloVeiculoEntity modelo = new ModeloVeiculoEntity();
		
		modelo.setNome(modeloForm.getNome());
		modelo.setMarca(marcaRepository.findById(modeloForm.getIdMarca()).orElse(null));
		modeloRepository.save(modelo);
	
		URI uri = uriBuilder.path("/modelo/{id}").
				buildAndExpand(modelo.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new ModeloVeiculoDTO(modelo));	
	}

	public ResponseEntity<ModeloVeiculoDTO> atualizar(Long id, @Valid ModeloForm modeloForm) {
		Optional<ModeloVeiculoEntity> modelo = modeloRepository.findById(id);
		
		if (modelo.isPresent()) {
			modelo.get().setNome(modeloForm.getNome());
			modeloRepository.save(modelo.get());
			return ResponseEntity.ok(new ModeloVeiculoDTO(modelo.get()));
		} 		
	
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<?> deletar(Long id) {
		Optional<ModeloVeiculoEntity> modelo = modeloRepository.findById(id);
		
		if (modelo.isPresent() ) {
			modeloRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();

	}
	
}
