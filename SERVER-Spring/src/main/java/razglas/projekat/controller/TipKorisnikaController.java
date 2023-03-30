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

import razglas.projekat.model.TipKorisnika;
import razglas.projekat.repository.TipKorisnikaRepository;
import razglas.projekat.service.TipKorisnikaService;

@RestController
@RequestMapping(value="/tipKorisnika")
@CrossOrigin(allowedHeaders="*",origins="*")
public class TipKorisnikaController {

	@Autowired
	TipKorisnikaRepository repo;
	
	@Autowired
	TipKorisnikaService service;
	
	@RequestMapping(value="/sve")
	public ArrayList<TipKorisnika> sve(){
		return (ArrayList<TipKorisnika>) repo.findAll();
	}
	
	@DeleteMapping(value="/izbrisi/{id}")
	public ArrayList<TipKorisnika> izbrisi(@PathVariable Long id){
		repo.deleteById(id);
		return (ArrayList<TipKorisnika>) repo.findAll();
	}
	
	@PutMapping(value="/izmena")
	public void izmeniTipKorisnika( @RequestBody TipKorisnika k) {
		var stari = repo.getReferenceById(k.getId());
		stari.setTip(k.getTip());
		repo.flush();
	}
	
	@PostMapping(value="/postTipKorisnika")
	public void postKorisnik(@RequestBody TipKorisnika tk) {
		service.postTipKorisnika(tk);
	}
	
	@GetMapping(value="/nadji/{id}")
	public TipKorisnika nadji(@PathVariable long id){
		return repo.findById(id).orElse(null);
	}
	
}
