package razglas.projekat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Grad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naziv;
	private String opstina;
	
	
	
	@OneToMany
	private List<Objekat> objekti = new ArrayList<>();
	@OneToMany
	private List<Dogadjaj> dogadjaj = new ArrayList<>();
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)	
	private Drzava drzava = new Drzava();

	public Drzava getDrzava() {
		return drzava;
	}

	public String getOpstina() {
		return opstina;
	}

	public void setOpstina(String opstina) {
		this.opstina = opstina;
	}

	public void setDrzava(Drzava drzava) {
		
		this.getDrzava().removeGrad(this);
		this.drzava = drzava;
		this.drzava.dodajGrad(this);
	}
	
	
	
	public Grad(long id, String naziv, String opstina, Drzava drzava) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opstina = opstina;
		this.drzava = drzava;
		this.objekti = null;
		this.dogadjaj = null;
		
	}

	public Grad() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Objekat> getObjekti() {
		return objekti;
	}

	public void setObjekti(List<Objekat> objekti) {
		this.objekti = objekti;
	}

	public List<Dogadjaj> getDogadjaj() {
		return dogadjaj;
	}

	public void setDogadjaj(List<Dogadjaj> dogadjaj) {
		this.dogadjaj = dogadjaj;
	}

	
}
