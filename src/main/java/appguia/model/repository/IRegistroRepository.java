package appguia.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import appguia.model.negocio.Registro;

@Repository
public interface IRegistroRepository extends CrudRepository<Registro, Integer>{
	
	List<Registro> findAll(Sort by);

}
