package appguia.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import appguia.model.negocio.Familia;
import appguia.model.repository.IFamiliaRepository;

@Service
public class FamiliaService {

	@Autowired private IFamiliaRepository familiaRepository;

	public List<Familia> obterLista(){
		return (List<Familia>)familiaRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}

	public void incluir(Familia familia) {
		familiaRepository.save(familia);
	}

	public void excluir(Integer id) {
		familiaRepository.deleteById(id);		
	}

	public Familia obterPorId(Integer id) {
		return familiaRepository.findById(id).orElse(null);
	}
}
