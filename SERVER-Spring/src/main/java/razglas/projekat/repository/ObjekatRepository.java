package razglas.projekat.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import razglas.projekat.model.GradDrzavaDTO;
import razglas.projekat.model.Objekat;
import razglas.projekat.model.ObjekatTipObjektaGradDTO;

@Repository
public interface ObjekatRepository extends JpaRepository<Objekat,Long> {
	
	@Query("Select new razglas.projekat.model.ObjekatTipObjektaGradDTO(o.id, o.naziv, o.tip.tip, o.grad.naziv)"
			+ " from Objekat o  left join TipObjekta to on o.tip=to.id "
			+ "left join Grad g on o.grad = g.id")
    ArrayList<ObjekatTipObjektaGradDTO> fetchObjekatTipObjektaGradDTO();

	
}
