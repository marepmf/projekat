package razglas.projekat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Komentar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private long id;
	private String tekst;
	private String vreme;
	private int lajkovi;
	
	@ManyToOne
	private Korisnik korisnik;
	@ManyToOne
	private Objava objava;

	
	
	public Komentar(long id, String tekst, String vreme, Korisnik korisnik, Objava objava) {
		super();
		this.id = id;
		this.tekst = tekst;
		this.vreme = vreme;
		this.lajkovi = 0;
		this.korisnik = korisnik;
		this.objava = objava;
	}
	
	public Komentar() {
		
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Objava getObjava() {
		return objava;
	}

	public void setObjava(Objava objava) {
		this.objava = objava;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public String getVreme() {
		return vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public int getLajkovi() {
		return lajkovi;
	}

	public void setLajkovi(int lajkovi) {
		this.lajkovi = lajkovi;
	}
	
	
}
