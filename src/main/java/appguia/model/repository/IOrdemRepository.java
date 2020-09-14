package appguia.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import appguia.model.negocio.Ordem;

@Repository
public interface IOrdemRepository extends CrudRepository<Ordem, Integer> {

	List<Ordem> findAll(Sort by);
}