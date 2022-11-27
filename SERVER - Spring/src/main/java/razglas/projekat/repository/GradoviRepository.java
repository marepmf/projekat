package razglas.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import razglas.projekat.model.Grad;

@Repository
public interface GradoviRepository extends JpaRepository<Grad, Long> {

}
