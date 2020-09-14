package appguia.model.negocio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TOrdem")
@PrimaryKeyJoinColumn(name = "idAve")
public class Ordem extends Ave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	public Ordem() {
	}
	
	public Ordem(String nome) {
		this.setNome(nome);
	}

	public Ordem(Integer id, String nome, float tamanho, String cor, String local, String autor,
			List<Registro> registros) {
		super(id, nome, tamanho, cor, local, autor, registros);
		// TODO Auto-generated constructor stub
	}

	public Ordem(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}
