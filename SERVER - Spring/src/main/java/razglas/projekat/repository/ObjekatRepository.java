package razglas.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import razglas.projekat.model.Objekat;

@Repository
public interface ObjekatRepository extends JpaRepository<Objekat,Long> {

}
