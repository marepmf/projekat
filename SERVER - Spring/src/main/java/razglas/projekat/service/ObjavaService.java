package razglas.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import razglas.projekat.model.Objava;
import razglas.projekat.repository.ObjavaRepository;

@Service
public class ObjavaService {

	@Autowired
	ObjavaRepository repo;
	
	public Objava postObjava(Objava o) {
		return repo.save(o);
	}
	
}
