package razglas.projekat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Drzava {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String naziv;
	
	@OneToMany
	private List<Grad> gradovi = new ArrayList<Grad>();

	public Drzava() {
		
	}
	public Drzava(long id, String naziv, List<Grad> gradovi) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.gradovi = gradovi;
	}
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
	public List<Grad> getGradovi() {
		return gradovi;
	}
	public void setGradovi(List<Grad> gradovi) {
		this.gradovi = gradovi;
	}
	
	public void dodajGrad(Grad g) {
		this.gradovi.add(g);
	}
	
	public void removeGrad(Grad g) {
		this.gradovi.remove(g);
	}
	
}
