package com.university.universitymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.universitymanagement.models.Studente;

public interface StudenteRepository extends JpaRepository<Studente,Long> {

}
