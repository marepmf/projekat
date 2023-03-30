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
public class TipObjekta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String tip;

	@OneToMany
	private List<Objekat> objekti = new ArrayList<>();
	
	public TipObjekta() {
		
	}
	
	public TipObjekta(long id, String tip) {
		super();
		this.id = id;
		this.tip = tip;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}

	public List<Objekat> getObjekti() {
		return objekti;
	}

	public void setObjekti(List<Objekat> objekti) {
		this.objekti = objekti;
	}
	
	
	
}
