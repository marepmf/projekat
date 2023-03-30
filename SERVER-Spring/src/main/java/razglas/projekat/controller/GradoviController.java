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

import razglas.projekat.model.Grad;
import razglas.projekat.repository.GradoviRepository;
import razglas.projekat.service.GradService;

@RestController
@RequestMapping(value="/gradovi")
@CrossOrigin(allowedHeaders="*",origins="*")
public class GradoviController {
	
	@Autowired
	private GradService gradService;
	
	@Autowired
	GradoviRepository repo;
	
	@PostMapping(value="/postGrad")
	public void postGrad(@RequestBody Grad grad) {
		gradService.postGrad(grad);
	}
	
	@RequestMapping(value="/sve")
	public ArrayList<Grad> sve(){
		return (ArrayList<Grad>) repo.findAll();
	}
	
	@DeleteMapping(value="/izbrisi/{id}")
	public ArrayList<Grad> izbrisi(@PathVariable int id){
		repo.deleteById((long) id);
		return (ArrayList<Grad>) repo.findAll();
	}
	
	@GetMapping(value="/nadji/{id}")
	public Grad nadji(@PathVariable long id){
		return repo.findById(id).orElse(null);
	}

	@PutMapping(value="/izmena")
	public void izmeni(@RequestBody Grad g)
	{
		var stari = repo.getReferenceById(g.getId());
		stari.setDrzava(g.getDrzava());
		stari.setNaziv(g.getNaziv());
		stari.setOpstina(g.getOpstina());
		repo.flush();
		
	}
}
