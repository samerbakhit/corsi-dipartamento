package com.samer.dipartimenti_corsi.servizi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.samer.dipartimenti_corsi.models.Dipartimento;
import com.samer.dipartimenti_corsi.repositories.DipartimentoRepository;

@Service
public class DipartimentoServizi {
	
	@Autowired
	DipartimentoRepository dr;
	
	public List<Dipartimento>findAllDipartimento(){
		return dr.findAll(Sort.by(Sort.Order.desc("id")));
	}
	public Dipartimento findDipartimentoById(Long id) {
		return dr.findById(id).orElse(null);
	}
	public void deleteDipartimentoById(Long id) {
		 dr.deleteById(id);
	}
	public boolean existeDipartimentoById(Long id) {
		return dr.existsById(id);
	}
	public Dipartimento addNewDipartimento(Dipartimento dipartimento) {
		return dr.save(dipartimento);
	}

}
