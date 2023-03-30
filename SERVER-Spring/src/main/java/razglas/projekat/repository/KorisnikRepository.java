package razglas.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import razglas.projekat.model.Korisnik;


@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{
	

}
