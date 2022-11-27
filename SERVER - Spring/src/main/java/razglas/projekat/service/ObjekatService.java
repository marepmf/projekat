package razglas.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import razglas.projekat.model.Objekat;
import razglas.projekat.repository.ObjekatRepository;

@Service
public class ObjekatService {
	
	@Autowired
	ObjekatRepository repo;
	
	public Objekat postObjekat(Objekat o) {
		return repo.save(o);
	}
	
}
