package razglas.projekat.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import razglas.projekat.model.Mesto;
import razglas.projekat.repository.MestoRepository;

@RestController
@RequestMapping(value="/mesto")
public class MestoController {
	
	@Autowired
	MestoRepository repo;
	
	@RequestMapping(value="/sve")
	public ArrayList<Mesto> sve(){
		return (ArrayList<Mesto>) repo.findAll();
	}
	
	@RequestMapping(value="/izbrisi/:id")
	public ArrayList<Mesto> izbrisi(@PathVariable int id){
		repo.deleteById((long) id);
		return (ArrayList<Mesto>) repo.findAll();
	}
}
