package razglas.projekat.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import razglas.projekat.model.Objava;
@Transactional
public interface ObjavaRepository extends JpaRepository<Objava, Long> {

	@Modifying
	@Query(value="delete from Objava where autor_id=:id",nativeQuery = true)	
	public void deleteAllObjavaWhereKorisnikID( @Param(value = "id") Long id);
	
	@Query("select o from Objava o where o.dogadjaj.id = :id")
	public ArrayList<Objava> findByEventId(@Param(value="id") Long id);
}
