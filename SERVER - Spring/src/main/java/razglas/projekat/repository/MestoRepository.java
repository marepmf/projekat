package razglas.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import razglas.projekat.model.Mesto;

public interface MestoRepository extends JpaRepository<Mesto, Long> {

}
