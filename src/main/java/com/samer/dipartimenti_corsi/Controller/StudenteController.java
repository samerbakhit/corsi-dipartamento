package com.samer.dipartimenti_corsi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samer.dipartimenti_corsi.models.Studente;
import com.samer.dipartimenti_corsi.servizi.StudenteService;

@RestController
@RequestMapping("/api/studenti")
public class StudenteController {
	  @Autowired
	    private StudenteService studenteService;

	    @GetMapping("/aggiorna")
	    public ResponseEntity<List<Studente>> aggiornaStudenti() {
	        List<Studente> studenti = studenteService.aggiornaStudentiDaMicroservizio();
	        return ResponseEntity.ok(studenti);
	    }

	    @GetMapping("/tutti")
	    public ResponseEntity<List<Studente>> getStudenti() {
	        return ResponseEntity.ok(studenteService.getStudenti());
	    }
}
