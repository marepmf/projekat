package razglas.projekat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Objava {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String tekst;
	private String naslov;
	private String vreme;
	@ManyToOne
	private Korisnik autor;
	@OneToMany
	private List<Komentar> komentari = new ArrayList<>(); 
	
	@JsonIgnore
	@ManyToOne
	private Dogadjaj dogadjaj;
	
	
	public Objava() {
		
	}
	
	public Objava(long id, String tekst, String naslov, String vreme, Dogadjaj dogadjaj) {
		super();
		this.id = id;
		this.tekst = tekst;
		this.naslov = naslov;
		this.vreme = vreme;
		this.autor = new Korisnik();
		this.dogadjaj = dogadjaj;
		
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
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public Dogadjaj getDogadjaj() {
		return dogadjaj;

	}
	public void setDogadjaj(Dogadjaj dogadjaj) {
		this.dogadjaj = dogadjaj;
	}
	
	public Korisnik getAutor() {
		return autor;
	}
	public void setAutor(Korisnik autor) {
		this.autor = autor;
	}
	public String getVreme() {
		return vreme;
	}
	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public List<Komentar> getKomentari() {
		return komentari;
	}

	public void setKomentari(List<Komentar> komentari) {
		this.komentari = komentari;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
