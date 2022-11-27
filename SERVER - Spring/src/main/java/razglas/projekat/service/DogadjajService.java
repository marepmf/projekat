package razglas.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import razglas.projekat.model.Dogadjaj;
import razglas.projekat.repository.DogadjajRepository;

@Service
public class DogadjajService {

	@Autowired
	DogadjajRepository repo;
	
	public Dogadjaj postDogadjaj(Dogadjaj d) {
		return repo.save(d);
	}
	
}
