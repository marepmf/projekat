package razglas.projekat.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Mesto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String grad;
	private String drzava;
	//@ManyToOne(cascade = CascadeType.ALL)
	//private Objava objava;
	
	
	
	public Mesto(int id, String grad, String drzava/*, Objava objava*/) {
		super();
		this.id = id;
		this.grad = grad;
		this.drzava = drzava;
		//this.objava = objava;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	/*
	public Objava getObjava() {
		return objava;
	}
	public void setObjava(Objava objava) {
		this.objava = objava;
	}
	*/
	
	
}
