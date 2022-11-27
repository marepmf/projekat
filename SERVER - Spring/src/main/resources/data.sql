insert into Tip_Korisnika (id, tip) values (1, 'Admin');
insert into Tip_Korisnika (id, tip) values (2, 'Adsfsdf');

insert into Tip_objekta (id, tip) values (1, 'Vanjski');

insert into Komentar (id,tekst,vreme,lajkovi) values(5,'f','3:00',4);

insert into Drzava (id, naziv) values (1, 'Srbija');
insert into Drzava (id, naziv) values (2, 'Bosna');
insert into Grad ( id, naziv, opstina,drzava_id) values (1,"Novi Sad", "Novi Sad",1);
insert into Grad ( id, naziv, opstina,drzava_id) values (2,"Sarajevo", "Sarejevo",2);

insert into  Dogadjaj(id,naziv, opis, datum, grad_id, slika )values(1,'Koncert', 'Koncert klasicne muzike', '3.4.2002' ,1,'../../assets/prva.png');
insert into  Dogadjaj(id,naziv,opis, datum,grad_id,slika)values(2,'Pozoriste','Mladi glumci na pozorisnom trgu','20.3.2012',1,'../../assets/druga.jpg');
insert into  Dogadjaj(id,naziv,opis,datum,grad_id,slika)values(3,'Vasar','Svasta za svakoga', '9.11.2021',1, '../../assets/treca.png');
insert into  Dogadjaj(id,naziv,opis,datum,grad_id,slika)values(4,'Cevabcijada','Takmicenje u pravljenju cevapa', '10.11.2021',2,'../../assets/prva.png');

insert into Korisnik(id,ime, prezime, tip_id) values( 1 , 'Admin', 'Adminovic', 1);
insert into Korisnik(id,ime, prezime, tip_id) values( 2 , 'Vlada', 'X', 2);
insert into Korisnik(id,ime, prezime, tip_id) values( 3 , 'Jelena', 'X', 2);
insert into Korisnik(id,ime, prezime, tip_id) values( 4 , 'Mira', 'X', 2);
insert into Korisnik(id,ime, prezime, tip_id) values( 5 , 'Jova', 'X', 2);

insert into Objava ( id, naslov, tekst, vreme, autor_id, dogadjaj_id) values( 1, 'Grupna poseta','Okuplnjanje ispred Mieltica..', '20:00', 2,1);
insert into Dogadjaj_objave (dogadjaj_id, objave_id) values(1,1);
insert into Objava ( id, naslov, tekst, vreme, autor_id, dogadjaj_id) values( 2, 'VIP poseta','Okuplnjanje ispred Mieltica..', '20:00', 3,1);
insert into Dogadjaj_objave (dogadjaj_id, objave_id) values(1,2);
insert into Objava ( id, naslov, tekst, vreme, autor_id, dogadjaj_id) values( 3, 'Poseta za fizicka lica','Prvo na pivo pa onda na koncert', '20:00', 5,1);
insert into Dogadjaj_objave (dogadjaj_id, objave_id) values(1,3);

