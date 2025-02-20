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

import com.university.universitymanagement.exception.UserNotFoundException;
import com.university.universitymanagement.models.Studente;
import com.university.universitymanagement.models.StudenteDTO;
import com.university.universitymanagement.services.StudenteService;

@RestController
@RequestMapping("/api/studenti")
public class StudenteController {
	@Autowired
	StudenteService ss;
	
	
	
	@GetMapping("/countstudenti")
	public String conteggio() {
		return "Abbiamo "+ ss.studentiConteggio()+" Studenti" ;
	}
	@GetMapping("/listastudenti")
	public List<Studente>getallStudente(){
		return ss.findAllStudenti();
	}
	@GetMapping("/{id}")
	public Studente getStudenteById(@PathVariable Long id){
		return ss.getStudenteById(id);
	}
	@PostMapping("/addnewstudente")
    public String addStudente(@RequestBody StudenteDTO studenteDTO) {
        ss.addStudente(studenteDTO);
        return "Studente aggiunto con tessera e Corsi!";
    }
	
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudente(@PathVariable Long id) {
		if(!ss.esiteStudenteById(id)) {
			throw new UserNotFoundException(id);
		}
		ss.deleteStudente(id);
		return "Lo sstudente con ID : "+id+" e stato cancellato";
	}
	
	@PutMapping("/update/{id}")
	public Studente updateStudente(@RequestBody StudenteDTO studenteDTO,@PathVariable Long id)
	{
		if(!ss.esiteStudenteById(id)) {
			throw new UserNotFoundException(id);
		}
		return ss.updateStudente(id, studenteDTO);
	}

}
