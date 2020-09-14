package appguia.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import appguia.model.negocio.Especie;
import appguia.model.repository.IEspecieRepository;

@Service
public class EspecieService {
	
	@Autowired private IEspecieRepository especieRepository;
	
	public List<Especie> obterLista(){
		return (List<Especie>)especieRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public void incluir(Especie especie) {
		especieRepository.save(especie);
	}

	public void excluir(Integer id) {
		especieRepository.deleteById(id);		
	}

	public Especie obterPorId(Integer id) {
		return especieRepository.findById(id).orElse(null);
	}
}