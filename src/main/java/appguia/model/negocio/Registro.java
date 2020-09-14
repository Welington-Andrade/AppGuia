package appguia.model.negocio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRegistro")
public class Registro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String local;
	private String nome;
	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "TRegistroAves",
			joinColumns = {@JoinColumn(name ="idAve")})
	private List<Ave> aves;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idObservador")
	private Observador observador;
	
	@Override
	public String toString() {
		return String.format("%d - %s - %s", 
					this.getId(),
					this.getLocal(),
					this.getNome()
				);
	}	
	
	public Registro() {
	}
	
	
	public Registro(Integer id, String local, String nome, List<Ave> aves, Observador observador) {
		this();
		this.setId(id);
		this.setLocal(local);
		this.setNome(nome);
		this.setAves(aves);
		this.setObservador(observador);
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ave> getAves() {
		return aves;
	}

	public void setAves(List<Ave> aves) {
		this.aves = aves;
	}


	public Observador getObservador() {
		return observador;
	}


	public void setObservador(Observador observador) {
		this.observador = observador;
	}
	
}
