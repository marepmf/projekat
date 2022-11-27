package razglas.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import razglas.projekat.model.Komentar;
import razglas.projekat.repository.KomentarRepository;

@Service
public class KomentarService {
	
	@Autowired
	KomentarRepository repo;
	
	public Komentar postKomentar(Komentar k){
		return repo.save(k);
	}
	
}
