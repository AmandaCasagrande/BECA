package br.com.everis.becaestacionamento.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.everis.becaestacionamento.entities.MovimentacoesEntity;
import br.com.everis.becaestacionamento.entities.VeiculoEntity;

public interface MovimentacoesRepository extends CrudRepository<MovimentacoesEntity, Long> {

	MovimentacoesEntity findByVeiculoAndStatus(VeiculoEntity veiculo, String status);

	public List<MovimentacoesEntity> findByDataSaidaBetweenAndStatus(LocalDateTime dataInicio, LocalDateTime dataSaida, String status);
	
}
