package br.com.everis.becaestacionamento.service;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.everis.becaestacionamento.dto.VeiculoDTO;
import br.com.everis.becaestacionamento.dto.form.VeiculoForm;
import br.com.everis.becaestacionamento.entities.VeiculoEntity;
import br.com.everis.becaestacionamento.repository.ModeloRepository;
import br.com.everis.becaestacionamento.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private ModeloRepository modeloRepository;

	public ResponseEntity<VeiculoDTO> cadastrar(@Valid VeiculoForm veiculoForm, UriComponentsBuilder uriBuilder) {
		VeiculoEntity veiculo = new VeiculoEntity();
		veiculo.setPlaca(veiculoForm.getPlaca());
		veiculo.setCor(veiculoForm.getCor());
		veiculo.setAno(veiculoForm.getAno());
		
		if (veiculoForm.getIdModelo() != null) {
			veiculo.setModelo(modeloRepository.findById(veiculoForm.getIdModelo()).orElse(null));
		}
		veiculoRepository.save(veiculo);
		
		URI uri = uriBuilder.path("/veiculo/{id}").
				buildAndExpand(veiculo.getIdVeiculo()).toUri();
		
		return ResponseEntity.created(uri).body(new VeiculoDTO(veiculo));
	}

	public ResponseEntity<VeiculoDTO> buscar(long id) {
		Optional<VeiculoEntity> veiculo = veiculoRepository.findById(id);
		
		if (veiculo.isPresent()) {
			return ResponseEntity.ok(new VeiculoDTO(veiculo.get()));
		}
		
		return ResponseEntity.notFound().build();

	}

	public ResponseEntity<VeiculoDTO> atualizar(Long id, @Valid VeiculoForm veiculoForm) {
		Optional<VeiculoEntity> veiculo = veiculoRepository.findById(id);
		
		if (veiculo.isPresent()) {
			veiculo.get().setPlaca(veiculoForm.getPlaca());
			veiculo.get().setAno(veiculoForm.getAno());
			veiculo.get().setCor(veiculoForm.getCor());
			veiculoRepository.save(veiculo.get());
			return ResponseEntity.ok(new VeiculoDTO(veiculo.get()));
		} 		
	
		return ResponseEntity.notFound().build();

	}

	public ResponseEntity<?> deletar(Long id) {
		Optional<VeiculoEntity> veiculo = veiculoRepository.findById(id);
		
		if (veiculo.isPresent() ) {
			veiculoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
		
}
