package razglas.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import razglas.projekat.model.Grad;
import razglas.projekat.repository.GradoviRepository;

@Service
public class GradService {

	@Autowired
	private GradoviRepository repo;
	
	public Grad postGrad(Grad grad) {
		return repo.save(grad);
	}
	
}
