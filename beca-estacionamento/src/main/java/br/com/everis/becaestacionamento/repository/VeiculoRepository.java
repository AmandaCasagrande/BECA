package br.com.everis.becaestacionamento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.everis.becaestacionamento.entities.VeiculoEntity;

@Repository
public interface VeiculoRepository extends CrudRepository<VeiculoEntity, Long> {
	
	VeiculoEntity findByPlaca(String placa);
	
}
