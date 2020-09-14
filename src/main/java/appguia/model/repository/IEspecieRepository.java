package appguia.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import appguia.model.negocio.Especie;

@Repository
public interface IEspecieRepository extends CrudRepository<Especie, Integer> {

	List<Especie> findAll(Sort by);
}
