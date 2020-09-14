package appguia.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import appguia.model.negocio.Observador;
import appguia.model.repository.IObservadorRepository;

@Service
public class ObservadorService {

@Autowired private IObservadorRepository repository;
	
	public void incluir(Observador observador) {
		repository.save(observador);
	}
	
	public List<Observador> obterLista() {
		return (List<Observador>)repository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}

	public void excluir(Integer id) {
		repository.deleteById(id);		
	}

	public Observador obterPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}
}
