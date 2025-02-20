package com.samer.dipartimenti_corsi.servizi;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.samer.dipartimenti_corsi.DTO.CorsoDTO;
import com.samer.dipartimenti_corsi.exception.CorsoNotFoundException;
import com.samer.dipartimenti_corsi.exception.DipartimentoNotFoundException;
import com.samer.dipartimenti_corsi.models.Corso;
import com.samer.dipartimenti_corsi.models.Dipartimento;
import com.samer.dipartimenti_corsi.repositories.CorsoRepository;
import com.samer.dipartimenti_corsi.repositories.DipartimentoRepository;

import jakarta.transaction.Transactional;

@Service
public class CorsoService {
@Autowired 
CorsoRepository cr;
@Autowired 
DipartimentoRepository dr;



@Autowired
StudenteService ss;



public List<Corso>findAllCorsi(){
	return cr.findAll(Sort.by(Sort.Order.desc("id")));
	
}
public boolean esisteCorsoById(Long id) {
	return cr.existsById(id);
}
public Corso findCorsoByID(Long id) {
return cr.findById(id)
		.orElseThrow(()->new CorsoNotFoundException("Corso non trovato con id "+id));
}
public void deleteCorsoById(Long id) {
	cr.deleteById(id);
}

@Transactional
public Corso addNewCorso(CorsoDTO corsoDTO)  {
	if (corsoDTO.getDipartimentoId()==null) {
		throw new DipartimentoNotFoundException("Il dipartimento Id non puo essere null");
	}
	Optional <Dipartimento> dipartimentoOpt = dr.findById(corsoDTO.getDipartimentoId());
	if(dipartimentoOpt.isEmpty()) {
		throw new DipartimentoNotFoundException("Il dipartimento non e trovato con ID: "+corsoDTO.getDipartimentoId());
	}
	
	Dipartimento dipartimento = dipartimentoOpt.get();
	
	Corso newCorso = new Corso();
	newCorso.setNome(corsoDTO.getNome());
	
	newCorso.setDescrizione(corsoDTO.getDescrizione());
	newCorso.setCrediti(corsoDTO.getCrediti());
	newCorso.setDipartimento(dipartimento);
	
	return cr.save(newCorso);
	
}
@Transactional
public Corso updateCorso(CorsoDTO corsoDto,Long id) {
	
	 Corso esisteCorso = cr.findById(id)
			 .orElseThrow(()->new CorsoNotFoundException("Corso non trovato con id "+id));
	
	 if(corsoDto.getDipartimentoId()!=null) {
		 
		Dipartimento dipartimento = dr.findById(corsoDto.getDipartimentoId())
				.orElseThrow(()-> new DipartimentoNotFoundException("Dipartimento non trovato con id: "+corsoDto.getDipartimentoId()));
	esisteCorso.setDipartimento(dipartimento);
		
	 }
	 
	 esisteCorso.setNome(corsoDto.getNome());
	 esisteCorso.setDescrizione(corsoDto.getDescrizione());
	 esisteCorso.setCrediti(corsoDto.getCrediti());
	return cr.save(esisteCorso);
	 
}
}
