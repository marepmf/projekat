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
	//@OneToMany
	//private List<Korisnik> korisnici = new ArrayList<>();
	public Drzava() {
		
	}
	public Drzava(long id, String naziv/*, List<Korisnik>korisnici*/) {
		super();
		this.id = id;
		this.naziv = naziv;
	//	this.korisnici = korisnici;
	}
/*
	public List<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(List<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}
*/
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
