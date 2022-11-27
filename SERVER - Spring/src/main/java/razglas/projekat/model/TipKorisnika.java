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

@Entity
public class TipKorisnika {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String tip;
	@OneToMany
	List<Korisnik> korisnik = new ArrayList<Korisnik>();
	


	public List<Korisnik> getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(List<Korisnik> korisnik) {
		this.korisnik = korisnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public TipKorisnika(Long id, String tip) {
		super();
		this.id = id;
		this.tip = tip;
	}
	
	public TipKorisnika() {
		
	}
	
}
