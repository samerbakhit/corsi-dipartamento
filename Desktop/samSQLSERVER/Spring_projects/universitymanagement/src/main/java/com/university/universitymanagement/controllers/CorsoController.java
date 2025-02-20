package com.university.universitymanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.universitymanagement.exception.CorsoAssociatoException;
import com.university.universitymanagement.exception.CorsoNotFoundException;

import com.university.universitymanagement.models.Corso;
import com.university.universitymanagement.models.CorsoDTO;
import com.university.universitymanagement.models.Studente;
import com.university.universitymanagement.repositories.CorsoRepository;
import com.university.universitymanagement.services.CorsoService;



@RestController
@RequestMapping("/api/corsi")
public class CorsoController {
@Autowired
CorsoService cs;
@Autowired
CorsoRepository cr;



@PutMapping("/update/{id}")
public String updateCorso(@PathVariable Long id,@RequestBody CorsoDTO corsoDTO)
{
 cs.modificare(id, corsoDTO);
 return "Corso e stato aggiornato  con successo";
}

@PostMapping("/addcorso")
public String addNewCorso(@RequestBody CorsoDTO corsoDTO)
{
 cs.aggiungere(corsoDTO);
 return "Corso e stato Aggiunto con successo";
}

@GetMapping("/countcorsobystudenti/{id}")
public int contacorsobystudenti(@PathVariable Long id){
	return cr.countCorsoByStudenti(id);
}


@GetMapping("/corsi_studenti/{id}")
public List<Studente>mostratutti(@PathVariable Long id){
	return cs.getStudentiByCorso(id);
}

@GetMapping ("/countcorsi")
public String countCorsi() {
return "Abbiamo " + cr.count()+ " Corsi";
}

@GetMapping("/listacorsi")
public List<Corso>showAllCorsi(){
	return cs.findAllCorsi();
}
@GetMapping("/{id}")
public Corso showCorsoById(@PathVariable Long id){
	return cs.findcorsoByid(id);
}

@DeleteMapping("/delete/{id}")
public String deleteCorsoById(@PathVariable Long id) {
	
	if(!cs.esisteCorsoByID(id)) {
		throw new CorsoNotFoundException(id);
	}
	   if (!cs.getStudentiByCorso(id).isEmpty()) {
		    throw new CorsoAssociatoException("Non si può cancellare un corso con studenti iscritti.");
		}
	 cs.deleteCorsoById(id);
	return "il corso con ID: "+id+" e stato cancellato";
}
}
