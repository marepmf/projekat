package razglas.projekat.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import razglas.projekat.model.Komentar;
import razglas.projekat.repository.KomentarRepository;
import razglas.projekat.service.KomentarService;

@RestController
@RequestMapping(value="/komentar")
@CrossOrigin(allowedHeaders="*",origins="*")
public class KomentarController {
	
	@Autowired
	KomentarRepository repo;
	
	@Autowired
	KomentarService service;
	
	@RequestMapping(value="/sve")
	public ArrayList<Komentar> sve(){
		return (ArrayList<Komentar>) repo.findAll();
	}
	
	@DeleteMapping(value="/izbrisi/{id}")
	public ArrayList<Komentar> izbrisi(@PathVariable int id){
		repo.deleteById((long) id);
		return (ArrayList<Komentar>) repo.findAll();
	}
	
	@PostMapping(value="/postKomentar")
	public void postKomentar(@RequestBody Komentar k) {
		service.postKomentar(k);
	}
	
	@GetMapping(value="/nadji/{id}")
	public Komentar nadji(@PathVariable long id) {
		return repo.findById(id).orElse(null);
	}
	
	@PutMapping(value="/izmena")
	public void izmeni(@RequestBody Komentar k) {
		var stari = repo.getReferenceById(k.getId());
		stari.setLajkovi(k.getLajkovi());
		stari.setTekst(k.getTekst());
		stari.setVreme(k.getVreme());
		repo.flush();
	}
	/*
	@RequestMapping(value="/dodaj/{id}/{t}/{k}/{o}")
	public ArrayList<Komentar> dodaj(@PathVariable int id,@PathVariable String tekst,
			@RequestBody Korisnik k ,@RequestBody Objava o){
		
		String v = LocalDateTime.now().toString();
		Komentar komentar = new Komentar(id, tekst, v, 0, k, o);
		repo.save(komentar);
		return (ArrayList<Komentar>) repo.findAll();
		
	}
	
	*/
	/*private int id;
	private String tekst;
	private String vreme;
	private int lajkovi;
	@ManyToOne
	private Korisnik korisnik;
	@ManyToOne
	private Objava objava;*/
	
}
