package appguia.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import appguia.model.negocio.Familia;

@Repository
public interface IFamiliaRepository extends CrudRepository<Familia, Integer> {

	List<Familia> findAll(Sort by);
}