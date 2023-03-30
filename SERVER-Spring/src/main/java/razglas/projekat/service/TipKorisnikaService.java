package razglas.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import razglas.projekat.model.TipKorisnika;
import razglas.projekat.repository.TipKorisnikaRepository;

@Service
public class TipKorisnikaService {

	@Autowired
	TipKorisnikaRepository repo;
	
	public TipKorisnika postTipKorisnika(TipKorisnika tk) {
		return repo.save(tk);
	}
	
}
