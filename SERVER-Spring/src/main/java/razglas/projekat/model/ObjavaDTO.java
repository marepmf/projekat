package razglas.projekat.model;

public class ObjavaDTO {

	private String tekst;
	private String naslov;
	private String vreme;
	private Korisnik autor;
	private Long dogadjaj;
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
	public String getVreme() {
		return vreme;
	}
	public void setVreme(String vreme) {
		this.vreme = vreme;
	}
	public Korisnik getAutor() {
		return autor;
	}
	public void setAutor(Korisnik autor) {
		this.autor = autor;
	}
	public Long getDogadjaj() {
		return dogadjaj;
	}
	public void setDogadjaj(Long dogadjaj) {
		this.dogadjaj = dogadjaj;
	}
	
}
