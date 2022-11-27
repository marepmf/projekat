package razglas.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import razglas.projekat.model.TipObjekta;
import razglas.projekat.repository.TipObjektaRepository;

@Service
public class TipObjektaService {

	@Autowired
	TipObjektaRepository repo;
	
	public TipObjekta postTipObjekta(TipObjekta to) {
		return repo.save(to);
	}
	
	
	
}
