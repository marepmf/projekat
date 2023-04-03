package razglas.projekat.controller;

import java.util.ArrayList;
import java.util.Optional;

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

import razglas.projekat.model.Dogadjaj;
import razglas.projekat.model.Komentar;
import razglas.projekat.model.Objava;
import razglas.projekat.model.ObjavaDTO;
import razglas.projekat.repository.DogadjajRepository;
import razglas.projekat.repository.KomentarRepository;
import razglas.projekat.repository.ObjavaRepository;
import razglas.projekat.service.ObjavaService;

@RestController
@RequestMapping(value="/objava")
@CrossOrigin(allowedHeaders="*",origins="*")
public class ObjavaController {
	
	@Autowired
	ObjavaRepository repo;
	@Autowired
	KomentarRepository komentarRepo;
	@Autowired
	DogadjajRepository eventRepo;
	@Autowired
	ObjavaService service;
	
	@RequestMapping(value="/sve")
	public ArrayList<Objava> sve(){
		return (ArrayList<Objava>) repo.findAll();
	}
	@GetMapping(value="/za_dogadjaj/{id}")
	public ArrayList<Objava> vratiObjaveZaDogadjaj(@PathVariable long id){
		System.out.print(" ID: " + id );
		System.out.println( repo.findByEventId(id));
		return (ArrayList<Objava>) repo.findByEventId(id);
	}
	
	@DeleteMapping(value="/izbrisi/{id}")
	public ArrayList<Objava> izbrisi(@PathVariable long id){
		repo.deleteById(id);
		return (ArrayList<Objava>) repo.findAll();
	}
	
	@PostMapping(value="/dodaj_komentar/{id}")
	public  void dodaj(@RequestBody String tekst, @PathVariable long id) {
		
		Komentar kom = new Komentar();
		kom.setLajkovi(0);
		kom.setTekst(tekst);
		Objava o = repo.findById(id).orElse(null);
		kom.setObjava(o);
		kom = komentarRepo.save(kom);
		if( o != null )
			{o.getKomentari().add(kom);
			repo.save(o);
			}
		
	}
	
	@PostMapping(value="/postObjava")
	public Optional<Dogadjaj> postObjava(@RequestBody ObjavaDTO o) {
		Objava obj = new Objava(o);
		obj.setDogadjaj(eventRepo.findById(o.getDogadjaj()).orElse(null));
		service.postObjava(obj);
		System.out.print(eventRepo.findById((long) 1));
		return eventRepo.findById(o.getDogadjaj());
		
		
	}
	
	@GetMapping(value="/nadji/{id}")
	public Objava nadji(@PathVariable long id) {
		return repo.findById(id).orElse(null);
	}
	
	@PutMapping(value="/izmena")
	public void izmeni(@RequestBody Objava o) {
		var stari = repo.getReferenceById(o.getId());
		stari.setAutor(o.getAutor());
		stari.setDogadjaj(o.getDogadjaj());
		stari.setNaslov(o.getNaslov());
		stari.setTekst(o.getTekst());
		repo.flush();
	}
	
}
