package razglas.projekat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Objekat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Long id;
	private String naziv;
	@ManyToOne
	private Grad grad;
	@ManyToOne
	private TipObjekta tip;
	
	public Objekat() {}	
	public Objekat(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}
	public Grad getGrad() {
		return grad;
	}

	public void setGrad(Grad grad) {
		this.grad = grad;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public TipObjekta getTip() {
		return tip;
	}
	public void setTip(TipObjekta tip) {
		this.tip = tip;
	}
		
}
