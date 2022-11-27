package razglas.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import razglas.projekat.model.Komentar;

public interface KomentarRepository extends JpaRepository<Komentar, Long> {

}
