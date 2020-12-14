package br.com.everis.becaestacionamento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.everis.becaestacionamento.entities.ModeloVeiculoEntity;

@Repository
public interface ModeloRepository extends CrudRepository<ModeloVeiculoEntity, Long>{

}
