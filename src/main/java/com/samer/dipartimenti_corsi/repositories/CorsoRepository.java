package com.samer.dipartimenti_corsi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samer.dipartimenti_corsi.models.Corso;

@Repository
public interface CorsoRepository extends JpaRepository<Corso,Long> {

}
