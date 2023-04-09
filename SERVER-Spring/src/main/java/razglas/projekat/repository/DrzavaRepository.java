package razglas.projekat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import razglas.projekat.model.Drzava;

@Transactional
@Repository
public interface DrzavaRepository extends JpaRepository<Drzava, Long>{

}
