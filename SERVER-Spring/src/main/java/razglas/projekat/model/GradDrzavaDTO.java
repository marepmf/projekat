package razglas.projekat.model;

public class GradDrzavaDTO {
	
	private long id;
	private String naziv;
    private String opstina;
    private String drzavaNaziv;
	
    public GradDrzavaDTO(long id, String naziv, String opstina, String drzavaNaziv) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opstina = opstina;
		this.drzavaNaziv = drzavaNaziv;
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

    public String getOpstina() {
        return opstina;
    }

    public void setOpstina(String opstina) {
        this.opstina = opstina;
    }

    public String getDrzavaNaziv() {
        return drzavaNaziv;
    }

    public void setDrzavaNaziv(String drzavaNaziv) {
        this.drzavaNaziv = drzavaNaziv;
    }
    
    
	
}
