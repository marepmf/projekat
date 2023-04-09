package razglas.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import razglas.projekat.model.Drzava;
import razglas.projekat.model.Grad;
import razglas.projekat.repository.DrzavaRepository;
import razglas.projekat.repository.GradoviRepository;

@Service
public class DrzavaService {
	
	@Autowired 
	DrzavaRepository repo;
	
	@Autowired
	GradoviRepository repog;
	
	public Drzava postDrzava(Drzava drzava){
		return repo.save(drzava);
	}
	
}
