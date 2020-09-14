package appguia.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import appguia.model.negocio.Observador;

@Repository
public interface IObservadorRepository extends CrudRepository<Observador, Integer> {

	List<Observador> findAll(Sort by);
}
