package razglas.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import razglas.projekat.model.Korisnik;
import razglas.projekat.repository.KorisnikRepository;

@Service
public class KorisnikService {
	
	@Autowired
	KorisnikRepository repo;
	
	public Korisnik postKorisnik(Korisnik k) {
		return repo.save(k);
	}
	
}
