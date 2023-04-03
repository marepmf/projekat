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

import razglas.projekat.model.Drzava;
import razglas.projekat.repository.DrzavaRepository;
import razglas.projekat.service.DrzavaService;

@RestController
@RequestMapping(value="/drzave")
@CrossOrigin(allowedHeaders="*",origins="*")
public class DrzaveController {
	
	@Autowired
	DrzavaRepository repo;
	
	@Autowired
	DrzavaService service;
	
	@RequestMapping(value="/sve")
	public ArrayList<Drzava> sve(){
		return (ArrayList<Drzava>) repo.findAll();
	}
	
	@DeleteMapping(value="/izbrisi/{id}")
	public ArrayList<Drzava> izbrisi(@PathVariable long id){
		repo.deleteById(id);
		return (ArrayList<Drzava>) repo.findAll();
	}
	
	@PostMapping(value="/postDrzava")
	public void postDrzava(@RequestBody Drzava drzava) {
		service.postDrzava(drzava);
	}
	
	@GetMapping(value="/nadji/{id}")
	public Drzava nadji(@PathVariable long id) {
		return repo.getReferenceById(id);
	}
	
	@PutMapping(value="/izmena")
	public void izmeni(@RequestBody Drzava d) {
		var stari = repo.getReferenceById(d.getId());
		stari.setGradovi(d.getGradovi());
		stari.setNaziv(d.getNaziv());
		repo.flush();
	}
	
}
