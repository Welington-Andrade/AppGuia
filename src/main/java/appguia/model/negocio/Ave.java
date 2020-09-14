package appguia.model.negocio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TAves")
@Inheritance(strategy = InheritanceType.JOINED)
public class Ave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private float tamanho;
	private String cor;
	private String local;
	private String autor;
	@ManyToMany(mappedBy = "aves")
	private List<Registro> registros;
	
	@Override
	public String toString() {
		return String.format("%s", this.getNome());
	}	
	
	public Ave() {
		
	}
	
	public Ave(Integer id) {
		this();
		this.setId(id);
	}
	
	public Ave(Integer id, String nome, float tamanho, String cor, String local, String autor,
			List<Registro> registros) {
		super();
		this.id = id;
		this.nome = nome;
		this.tamanho = tamanho;
		this.cor = cor;
		this.local = local;
		this.autor = autor;
		this.registros = registros;
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

	public float getTamanho() {
		return tamanho;
	}

	public void setTamanho(float tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
		
}
