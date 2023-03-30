package razglas.projekat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



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
	public Drzava(long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}
	public long getId() {
		return id;
	}

	public void setId(int id) {
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
	
	
	
}
