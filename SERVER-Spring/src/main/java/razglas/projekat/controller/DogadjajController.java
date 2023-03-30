package razglas.projekat.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import razglas.projekat.model.Dogadjaj;
import razglas.projekat.repository.DogadjajRepository;
import razglas.projekat.service.DogadjajService;

@RestController
@RequestMapping(value="/dogadjaj")
@CrossOrigin(allowedHeaders="*",origins="*")
public class DogadjajController {
	
	@Autowired
	DogadjajRepository repo;
	
	@Autowired
	DogadjajService service;
	
	@RequestMapping(value="/sve")
	public ArrayList<Dogadjaj> sve(){
		return (ArrayList<Dogadjaj>)repo.findAll();
	}
	@RequestMapping(value="/nesto/{id}", method=RequestMethod.GET)
	public Dogadjaj vratiDogadjaj(@PathVariable long id){
		return repo.findById(id).orElse(null);
	}
	
	@DeleteMapping(value="/izbrisi/{id}")
	public ArrayList<Dogadjaj> izbrisi(@PathVariable long id){
		repo.deleteById(id);
		return (ArrayList<Dogadjaj>) repo.findAll();
	}
	
	@PostMapping(value="/postDogadjaj")
	public void postDogadjaj(@RequestBody Dogadjaj d) {
		service.postDogadjaj(d);
	}
	
}
