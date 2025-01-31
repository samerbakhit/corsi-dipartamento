package com.samer.dbCrud.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.samer.dbCrud.Model.Studenti;
import com.samer.dbCrud.Repository.StudentiRepository;

@Service
public class StudentiServizi {
	@Autowired 
	StudentiRepository sr;
	
	public long countStudenti() {
		
		return  sr.count();
	}
	public List<Studenti> getALlStudenti() {
		return sr.findAll(Sort.by(Sort.Order.desc("id")));
	}
	public Studenti getStudenteById(Long id) {
		return sr.findById(id).orElse(null);
		
	}
	public void deleteStudente(Long id) {
		sr.deleteById(id);
	}
	public Studenti saveStudente(Studenti studente) {
	    if (studente.getId()!= null) {
	        Optional<Studenti> existingUser = sr.findById(studente.getId());
	        if (existingUser.isPresent()) {
	            Studenti updatedUser = existingUser.get();
	            updatedUser.setNome(studente.getNome());
	            updatedUser.setCognome(studente.getCognome());
	            updatedUser.setAnni(studente.getAnni());
	            sr.save(updatedUser);
	         
	        }
	    }
	  return sr.save(studente);
	}

}
