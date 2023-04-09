package razglas.projekat.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import razglas.projekat.model.Grad;
import razglas.projekat.model.GradDrzavaDTO;

@Transactional
@Repository
public interface GradoviRepository extends JpaRepository<Grad, Long> {
	
	@Query("Select new razglas.projekat.model.GradDrzavaDTO(g.id, g.naziv, g.opstina, d.naziv) from Grad g  left join Drzava d on g.drzava.id=d.id")
    ArrayList<GradDrzavaDTO> fetchGradDrzava();

	
}
