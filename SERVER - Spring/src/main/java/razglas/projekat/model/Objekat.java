package razglas.projekat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Objekat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	Long id;
	String naziv;
	
	public Objekat() {
		
	}
	
	
	
	public Objekat(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
	
}
