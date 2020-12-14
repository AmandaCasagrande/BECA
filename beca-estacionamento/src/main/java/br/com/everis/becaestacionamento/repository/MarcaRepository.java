package br.com.everis.becaestacionamento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.everis.becaestacionamento.entities.MarcaVeiculoEntity;

@Repository
public interface MarcaRepository extends CrudRepository<MarcaVeiculoEntity, Long>{

}
