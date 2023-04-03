package razglas.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import razglas.projekat.model.Korisnik;
import razglas.projekat.model.Kredencijali;
import razglas.projekat.model.TipKorisnika;
import razglas.projekat.repository.KorisnikRepository;
import razglas.projekat.repository.ObjavaRepository;
import razglas.projekat.repository.TipKorisnikaRepository;

@RestController
@RequestMapping(value="/korisnici")
@CrossOrigin(allowedHeaders="*",origins="*")
public class KorisnikController {
	@Autowired
	KorisnikRepository repo;
	@Autowired
	private TipKorisnikaRepository tkrepo;
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
	public @ResponseBody void dodajKorisnika(@RequestBody Korisnik korisnik) {
		System.out.print(korisnik);
		TipKorisnika r = tkrepo.findById(2l).orElse(null);
		korisnik.setTip(r);
		repo.save(korisnik);
		
	}
	
	@RequestMapping(value="/izbrisi", method = RequestMethod.GET)
	public ArrayList<Korisnik> izbrisi(@RequestParam(name="id") Long id){
		objava_repo.deleteAllObjavaWhereKorisnikID(id);
		repo.deleteById((long) id);
		return (ArrayList<Korisnik>) repo.findAll();
	}
	
	@RequestMapping( value="/login", method=RequestMethod.POST)
	public Korisnik login( @RequestBody Kredencijali kredencijali) {
		ArrayList<Korisnik> svi = (ArrayList<Korisnik>) repo.findAll();
		for( Korisnik k : svi) {
			// username == email			
			if( k.getEmail().equals(kredencijali.username) && k.getSifra().equals( kredencijali.password)) {				
				return k;	
			}
		}
		return null;
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
