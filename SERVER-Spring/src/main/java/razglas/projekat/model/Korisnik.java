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
	private String email;
	private String sifra;
	@ManyToOne
	private TipKorisnika tip;
	
	@OneToMany
	List<Objava> objave = new ArrayList<Objava>();	
	@OneToMany
	List<Komentar> komentari = new ArrayList<>();
	
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
		return "Korisnik [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", sifra=" + sifra
				+ ", tip=" + tip + ", objave=" + objave + ", komentari=" + komentari + "]";
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
	public List<Objava> getObjave() {
		return objave;
	}
	public void setObjave(List<Objava> objave) {
		this.objave = objave;
	}
	public List<Komentar> getKomentari() {
		return komentari;
	}
	public void setKomentari(List<Komentar> komentari) {
		this.komentari = komentari;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
	
	
}
