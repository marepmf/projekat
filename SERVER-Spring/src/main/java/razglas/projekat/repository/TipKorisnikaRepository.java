package razglas.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import razglas.projekat.model.TipKorisnika;

@Repository
public interface TipKorisnikaRepository extends JpaRepository<TipKorisnika, Long> {

}
