package appguia.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import appguia.model.negocio.Ordem;
import appguia.model.repository.IOrdemRepository;

@Service
public class OrdemService {
	
	@Autowired private IOrdemRepository ordemRepository;

	public List<Ordem> obterLista(){
		return (List<Ordem>)ordemRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}

	public void incluir(Ordem ordem) {
		ordemRepository.save(ordem);
	}

	public void excluir(Integer id) {
		ordemRepository.deleteById(id);		
	}

	public Ordem obterPorId(Integer id) {
		return ordemRepository.findById(id).orElse(null);
	}
}