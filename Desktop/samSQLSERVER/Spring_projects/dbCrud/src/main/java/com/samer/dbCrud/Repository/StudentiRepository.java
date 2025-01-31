package com.samer.dbCrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samer.dbCrud.Model.Studenti;

public interface StudentiRepository extends JpaRepository<Studenti,Long> {
	long count();

}
