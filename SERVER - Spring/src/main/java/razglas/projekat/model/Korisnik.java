package razglas.projekat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Korisnik {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String ime;
	private String prezime;
	@ManyToOne
	private TipKorisnika tip;
	@OneToMany
	List<Objava> objave = new ArrayList<Objava>();	
	public void setTip(TipKorisnika tip) {
		this.tip = tip;
	}
	public Korisnik() {}

	
	public Korisnik(Long id, String ime, String prezime, TipKorisnika tip) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.tip = tip;
	}
	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	
	public TipKorisnika getTip() {
		return tip;
	}
	@Override
	public String toString() {
		return "Korisnik [id=" + id + ", ime=" + ime + "]";
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
	
	
	
}
