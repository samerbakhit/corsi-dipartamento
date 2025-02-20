package com.university.universitymanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.university.universitymanagement.exception.CorsoAssociatoException;
import com.university.universitymanagement.exception.CorsoNotFoundException;
import com.university.universitymanagement.exception.DipartamentoNotFoundException;
import com.university.universitymanagement.models.Corso;
import com.university.universitymanagement.models.CorsoDTO;
import com.university.universitymanagement.models.Dipartamento;
import com.university.universitymanagement.models.Studente;
import com.university.universitymanagement.repositories.CorsoRepository;
import com.university.universitymanagement.repositories.DipartamentoRepository;

import jakarta.transaction.Transactional;

@Service
public class CorsoService {
	@Autowired
	CorsoRepository cr;
	@Autowired
	DipartamentoRepository dr;
	
	
	
	public List<Studente>getStudentiByCorso(Long corsoId) {
	    return cr.findStudentiByCorsoId(corsoId);
	}

	

		public List<Corso>findAllCorsi(){
		return cr.findAll(Sort.by(Sort.Order.desc("id")));
	}
		
	public Corso findcorsoByid(Long id) {
		return cr.findById(id).orElseThrow(()-> new CorsoNotFoundException(id));
	}
	//@Transactional
	public void deleteCorsoById(Long id) {
	  
		   	cr.deleteById(id);
	   
	    
	}
	
public boolean esisteCorsoByID(Long id) {
	return cr.existsById(id);
	
}

@Transactional
public Corso aggiungere(CorsoDTO corsoDTO) {
    if (corsoDTO.getDipartimentoId() == null) {
        throw new DipartamentoNotFoundException("Dipartimento ID non può essere null");
    }

    // Verifica che il dipartimento esista
    Optional<Dipartamento> dipartimentoOpt = dr.findById(corsoDTO.getDipartimentoId());
    if (dipartimentoOpt.isEmpty()) {
        throw new DipartamentoNotFoundException("Dipartimento non trovato con ID: " + corsoDTO.getDipartimentoId());
    }

    Dipartamento dipartimento = dipartimentoOpt.get();

    // Creazione del corso
    Corso nuovoCorso = new Corso();
    nuovoCorso.setNome(corsoDTO.getNome());
    nuovoCorso.setDescrizione(corsoDTO.getDescrizione());
    nuovoCorso.setCrediti(corsoDTO.getCrediti());
    nuovoCorso.setDipartamento(dipartimento);

    // Salvataggio del corso
    return cr.save(nuovoCorso);
}
@Transactional
public Corso modificare(Long id, CorsoDTO corsoDTO) {
    // Controllo se il corso esiste
    Corso corsoEsistente = cr.findById(id)
            .orElseThrow(() -> new CorsoNotFoundException(id));

    // Verifica che il Dipartimento esista (se specificato)
    if (corsoDTO.getDipartimentoId() != null) {
        Dipartamento dipartimento = dr.findById(corsoDTO.getDipartimentoId())
                .orElseThrow(() -> new DipartamentoNotFoundException("Dipartimento non trovato con ID: " + corsoDTO.getDipartimentoId()));
        corsoEsistente.setDipartamento(dipartimento);
    }

    // Aggiorna il nome del corso se presente nel DTO
    if (corsoDTO.getNome() != null && !corsoDTO.getNome().isEmpty()) {
        corsoEsistente.setNome(corsoDTO.getNome());
        corsoEsistente.setDescrizione(corsoDTO.getDescrizione());
        corsoEsistente.setCrediti(corsoDTO.getCrediti());
    }

    // Salvataggio e ritorno del corso aggiornato
    return cr.save(corsoEsistente);
}


}