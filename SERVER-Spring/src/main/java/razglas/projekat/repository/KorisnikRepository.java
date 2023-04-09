package razglas.projekat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import razglas.projekat.model.Korisnik;

@Transactional
@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{
	

}
