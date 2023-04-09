package razglas.projekat.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import razglas.projekat.model.Grad;
import razglas.projekat.model.GradDrzavaDTO;
import razglas.projekat.repository.GradoviRepository;

@Service
public class GradService {

	@Autowired
	private GradoviRepository repo;
	
	
	
	public Grad postGrad(Grad grad) {
		return repo.save(grad);
	}
	
	public ArrayList<GradDrzavaDTO> sve(){
		return (ArrayList<GradDrzavaDTO>) repo.fetchGradDrzava();
	}
	
}
