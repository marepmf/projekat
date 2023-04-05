package razglas.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import razglas.projekat.model.Drzava;

@Repository
public interface DrzavaRepository extends JpaRepository<Drzava, Long>{

}
