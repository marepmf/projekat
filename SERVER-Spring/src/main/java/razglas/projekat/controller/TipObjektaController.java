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

import razglas.projekat.model.TipObjekta;
import razglas.projekat.repository.TipObjektaRepository;
import razglas.projekat.service.TipObjektaService;

@RestController
@RequestMapping(value="/tipObjekta")
@CrossOrigin(allowedHeaders="*",origins="*")
public class TipObjektaController {
	
	@Autowired
	TipObjektaRepository repo;
	
	@Autowired
	TipObjektaService service;
	
	@RequestMapping(value="/sve")
	public ArrayList<TipObjekta> sve(){
		return (ArrayList<TipObjekta>) repo.findAll();
	}
	
	@DeleteMapping(value="/izbrisi/{id}")
	public ArrayList<TipObjekta> izbrisi(@PathVariable long id){
		repo.deleteById(id);
		return (ArrayList<TipObjekta>) repo.findAll();
	}
	
	@PostMapping(value="/postTipObjekta")
	public void postTipObjekta(@RequestBody TipObjekta tk) {
		service.postTipObjekta(tk);
	}
	
	@GetMapping(value="/nadji/{id}")
	public TipObjekta nadjiTipObjekta(@PathVariable long id) {
		return repo.findById(id).orElse(null);
	}
	
	@PutMapping(value="/izmena")
	public void izmeni(@RequestBody TipObjekta to) {
		var stari = repo.getReferenceById(to.getId());
		stari.setTip(to.getTip());
		repo.flush();
	}
	
}
