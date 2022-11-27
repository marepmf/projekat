package razglas.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import razglas.projekat.model.Korisnik;
import razglas.projekat.repository.KorisnikRepository;
import razglas.projekat.repository.ObjavaRepository;

@RestController
@RequestMapping(value="/korisnici")
@CrossOrigin(allowedHeaders="*",origins="*")
public class KorisnikController {
	@Autowired
	KorisnikRepository repo;
	@Autowired
	ObjavaRepository objava_repo;

	@RequestMapping(value="/sve")
	public List<Korisnik> sve() {
		return repo.findAll();
	}

	@RequestMapping(value="/prikazi_formu_za_dodavanje")
	public ModelAndView dodajKorisnika() {
		ModelAndView m = new ModelAndView("dodavanje_korisnika");
		return m;
	}
	
	@RequestMapping(value="/dodaj", method= RequestMethod.POST)
	public @ResponseBody ModelAndView dodajKorisnika( Korisnik korisnik) {
		repo.save(korisnik);
		ModelAndView m = new ModelAndView("svi_korisnici");
		m.addObject("korisnici", repo.findAll());
		return m;
	}
	
	@RequestMapping(value="/izbrisi", method = RequestMethod.GET)
	public ArrayList<Korisnik> izbrisi(@RequestParam(name="id") Long id){
		objava_repo.deleteAllObjavaWhereKorisnikID(id);
		repo.deleteById((long) id);
		return (ArrayList<Korisnik>) repo.findAll();
	}
	
	@RequestMapping(value="/korisnik/{id}")
	public ModelAndView vratiKorisnikaPoID(@PathVariable Long id) {
		Korisnik k = repo.findById(id).orElse(null);
		if( k == null)
			return new ModelAndView("404");
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("pocetna");
		 modelAndView.addObject("user",k);
		 return modelAndView;
		
	}
	
}
