package razglas.projekat.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Dogadjaj {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String naziv;
	private String opis;
	private String datum;
	private String slika;
	@ManyToOne
	private Grad grad;
	
	@OneToMany
	private List<Objava> objave;
	public List<Objava> getObjave() {
		return objave;
	}

	public void setObjave(List<Objava> objave) {
		this.objave = objave;
	}

	
	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public Grad getGrad() {
		return grad;
	}

	public void setGrad(Grad grad) {
		this.grad = grad;
	}

	public List<Korisnik> getGosti() {
		return gosti;
	}

	public void setGosti(List<Korisnik> gosti) {
		this.gosti = gosti;
	}
	@OneToMany
	private List<Korisnik> gosti;
	
	
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

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	@Override
	public String toString() {
		return "Dogadjaj [id=" + id + ", naziv=" + naziv + ", opis=" + opis + ", datum=" + datum + ", slika=" + slika
				+ ", grad=" + grad + ", objave=" + objave + ", gosti=" + gosti + "]";
	}
	
	
}
