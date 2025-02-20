package com.samer.dipartimenti_corsi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samer.dipartimenti_corsi.models.Studente;

public interface Studenterepository extends JpaRepository<Studente,Long> {

	Optional<Studente> findByEmail(String email);
	
}
