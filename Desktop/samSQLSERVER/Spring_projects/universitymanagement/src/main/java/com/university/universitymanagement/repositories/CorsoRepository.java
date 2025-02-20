package com.university.universitymanagement.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.university.universitymanagement.models.Corso;
import com.university.universitymanagement.models.Studente;


public interface CorsoRepository extends JpaRepository<Corso,Long> {
	
	@Query(value = "SELECT s.* FROM studente s " +
            "JOIN studenti_corsi sc ON s.id = sc.studente_id " +
            "WHERE sc.corso_id = :corsoId", 
    nativeQuery = true)
public List<Studente> findStudentiByCorsoId(@Param("corsoId") Long corsoId);
	
	@Query(value = "SELECT COUNT(*) FROM studente s " +
            "JOIN studenti_corsi sc ON s.id = sc.studente_id " +
            "WHERE sc.corso_id = :corsoId", 
    nativeQuery = true)
public int countCorsoByStudenti(@Param("corsoId") Long corsoId);
	
}
