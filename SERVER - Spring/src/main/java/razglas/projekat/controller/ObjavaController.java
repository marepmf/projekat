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

import razglas.projekat.model.Objava;
import razglas.projekat.repository.ObjavaRepository;
import razglas.projekat.service.ObjavaService;

@RestController
@RequestMapping(value="/objava")
@CrossOrigin(allowedHeaders="*",origins="*")
public class ObjavaController {
	
	@Autowired
	ObjavaRepository repo;
	
	@Autowired
	ObjavaService service;
	
	@RequestMapping(value="/sve")
	public ArrayList<Objava> sve(){
		return (ArrayList<Objava>) repo.findAll();
	}
	
	@DeleteMapping(value="/izbrisi/{id}")
	public ArrayList<Objava> izbrisi(@PathVariable long id){
		repo.deleteById(id);
		return (ArrayList<Objava>) repo.findAll();
	}
	
	@PostMapping(value="/postObjava")
	public void postObjava(@RequestBody Objava o) {
		service.postObjava(o);
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
