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

import razglas.projekat.model.Objekat;
import razglas.projekat.model.ObjekatTipObjektaGradDTO;
import razglas.projekat.repository.ObjekatRepository;
import razglas.projekat.service.ObjekatService;

@RestController
@RequestMapping(value="/objekat")
@CrossOrigin(allowedHeaders="*",origins="*")
public class ObjekatController {

	@Autowired
	ObjekatRepository repo;
	
	@Autowired
	ObjekatService service;
	
	@RequestMapping(value="/sve")
	public ArrayList<ObjekatTipObjektaGradDTO> sve(){
		return (ArrayList<ObjekatTipObjektaGradDTO>) service.sve();
	}
	
	@DeleteMapping(value="/izbrisi/{id}")
	public ArrayList<Objekat> izbrisi(@PathVariable Long id){
		repo.deleteById(id);
		return (ArrayList<Objekat>) repo.findAll();
	}
	
	@PostMapping(value="/postObjekat")
	public void dodajObjekat(@RequestBody Objekat o) {
		service.postObjekat(o);
	}
	
	@GetMapping(value="/nadji/{id}")
	public Objekat nadji(@PathVariable long id) {
		return repo.findById(id).orElse(null);
	}
	
	@PutMapping(value="/izmena")
	public void izmeni(@RequestBody Objekat o) {
		var stari = repo.getReferenceById(o.getId());
		stari.setNaziv(o.getNaziv());
		repo.flush();
	}
}
