package razglas.projekat.model;

public class ObjekatTipObjektaGradDTO {
	
	long id;
	String naziv;
	String tipObjekta;
	String grad;
	
	public ObjekatTipObjektaGradDTO(long id, String naziv, String tipObjekta, String grad) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.tipObjekta = tipObjekta;
		this.grad = grad;
	}

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

	public String getTipObjekta() {
		return tipObjekta;
	}

	public void setTipObjekta(String tipObjekta) {
		this.tipObjekta = tipObjekta;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}
	
}
