package razglas.projekat.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import razglas.projekat.model.Objava;
import razglas.projekat.repository.ObjavaRepository;

@Service
@CrossOrigin(allowedHeaders="*",origins="*")
public class ObjavaService {

	@Autowired
	ObjavaRepository repo;
	
	public Objava postObjava(Objava o) {
		return repo.save(o);
	}
	
	public ArrayList<Objava> vratiSveObjaveZaDOgadjaj( long id){
		return null;
	}
}
