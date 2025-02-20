package com.university.universitymanagement.services;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.university.universitymanagement.exception.CorsoNotFoundException;
import com.university.universitymanagement.exception.UserNotFoundException;
import com.university.universitymanagement.models.Corso;
import com.university.universitymanagement.models.Studente;
import com.university.universitymanagement.models.StudenteDTO;
import com.university.universitymanagement.models.Tessera;
import com.university.universitymanagement.repositories.CorsoRepository;
import com.university.universitymanagement.repositories.StudenteRepository;
import com.university.universitymanagement.repositories.TesseraRepository;

import jakarta.transaction.Transactional;

@Service
public class StudenteService {
	
	@Autowired
	StudenteRepository sr;
	@Autowired
	CorsoRepository cr;
	@Autowired
	TesseraRepository tr;
	
	public Long studentiConteggio() {
		return sr.count();
	}
	
	public List<Studente>findAllStudenti(){
		return sr.findAll(Sort.by(Sort.Order.desc("id")));
	}
	public Studente getStudenteById(Long id) {
		return sr.findById(id).orElseThrow(()-> new UserNotFoundException(id));
	}
	
	@Transactional
	public Studente addStudente(StudenteDTO studenteDTO) {
		 // Crea la tessera
        Tessera tessera = new Tessera();
        tessera.setCodice(studenteDTO.getCodiceTessera());
        tessera.setDataEmissione(studenteDTO.getDataEmissione());
        tessera.setStato(studenteDTO.getStatoTessera());

        // Salva la tessera
        tr.save(tessera);
     // Crea lo studente
        Studente studente = new Studente();
        studente.setNome(studenteDTO.getNome());
        studente.setCognome(studenteDTO.getCognome());
        studente.setEmail(studenteDTO.getEmail());
        studente.setDataNascita(studenteDTO.getDataNascita());
        studente.setTessera(tessera); // Associa la tessera allo studente

        // Gestione Corsi
        if (studenteDTO.getCorsoIds() != null && !studenteDTO.getCorsoIds().isEmpty()) {
            Set<Corso> corsi = new HashSet<>();
            for (Long corsoId : studenteDTO.getCorsoIds()) {
                Corso corso = cr.findById(corsoId)
                        .orElseThrow(() -> new RuntimeException("Corso non trovato con id: " + corsoId));
                corsi.add(corso);
            }
            studente.setCorsi(corsi); // Associa i corsi allo studente
        }
        // Salva lo studente
        return sr.save(studente);
	}

	
	
	
public void deleteStudente(Long id) {
		sr.deleteById(id);
	}
public boolean esiteStudenteById(Long id) {
	return sr.existsById(id);
	
}


@Transactional
public Studente updateStudente(Long id, StudenteDTO studenteDTO) {
    Studente studente = sr.findById(id)
            .orElseThrow(() -> new RuntimeException("Studente non trovato con id: " + id));

   
    studente.setNome(studenteDTO.getNome());
    studente.setCognome(studenteDTO.getCognome());
    studente.setEmail(studenteDTO.getEmail());
    studente.setDataNascita(studenteDTO.getDataNascita());

   
    Tessera tessera = studente.getTessera();
    if (tessera == null) {
        tessera = new Tessera();
        studente.setTessera(tessera); 
    }

    tessera.setCodice(studenteDTO.getCodiceTessera());
    tessera.setDataEmissione(studenteDTO.getDataEmissione());
    tessera.setStato(studenteDTO.getStatoTessera());

   
 // Aggiorna i corsi
    if (studenteDTO.getCorsoIds() != null) {
        Set<Corso> corsiAssociati = new HashSet<>();
        for (Long corsoId : studenteDTO.getCorsoIds()) {
            Corso corso = cr.findById(corsoId)
                    .orElseThrow(() -> new CorsoNotFoundException(corsoId));
            corsiAssociati.add(corso);
        }
        studente.setCorsi(corsiAssociati);
    }
    
    
    
    
    return sr.save(studente);
}
	
}
