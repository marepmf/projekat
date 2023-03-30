package razglas.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import razglas.projekat.model.Drzava;
import razglas.projekat.repository.DrzavaRepository;

@Service
public class DrzavaService {
	
	@Autowired 
	DrzavaRepository repo;
	
	public Drzava postDrzava(Drzava drzava){
		return repo.save(drzava);
	}
	
}
