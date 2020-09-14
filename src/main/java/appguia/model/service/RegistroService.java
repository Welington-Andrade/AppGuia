package appguia.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import appguia.model.negocio.Registro;
import appguia.model.repository.IRegistroRepository;

@Service
public class RegistroService {
	
@Autowired private IRegistroRepository registroRepository;
	
	public void incluir(Registro registro) {
		registroRepository.save(registro);
	}
	
	public List<Registro> obterLista(){
		return (List<Registro>)registroRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}

	public Registro obterPorId(Integer id) {
		return registroRepository.findById(id).orElse(null);
	}

	public void excluir(Integer id) {
		registroRepository.deleteById(id);
	}
}