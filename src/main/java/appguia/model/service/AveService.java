package appguia.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import appguia.model.negocio.Ave;
import appguia.model.repository.IAveRepository;

@Service
public class AveService {
	
	@Autowired private IAveRepository aveRepository;
	
	public List<Ave> obterLista(){
		
		return (List<Ave>)aveRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public void excluir(Integer id) {
		aveRepository.deleteById(id);
	}
}