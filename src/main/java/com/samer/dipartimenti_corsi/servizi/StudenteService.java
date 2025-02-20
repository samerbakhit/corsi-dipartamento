package com.samer.dipartimenti_corsi.servizi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.samer.dipartimenti_corsi.DTO.StudenteDTO;
import com.samer.dipartimenti_corsi.models.Studente;
import com.samer.dipartimenti_corsi.repositories.Studenterepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudenteService {
	@Autowired
    RestTemplate restTemplate;
	
	 @Autowired
	  private Studenterepository studenteRepository;

  public List<StudenteDTO> getStudentiFromMicroservizio() {
        String url = "http://localhost:8082/api/studenti/listastudenti"; // URL dell'API esistente nel progetto Studenti
        ResponseEntity<StudenteDTO[]> response = restTemplate.getForEntity(url, StudenteDTO[].class);
        return Arrays.asList(response.getBody());
    }
 

  public List<Studente> aggiornaStudentiDaMicroservizio() {
      String url = "http://localhost:8082/api/studenti/listastudenti"; // URL del microservizio Studenti
      ResponseEntity<StudenteDTO[]> response = restTemplate.getForEntity(url, StudenteDTO[].class);
      List<StudenteDTO> studentiDTO = Arrays.asList(response.getBody());

      // Convertiamo StudenteDTO in Studente e lo salviamo nel database
      List<Studente> studenti = studentiDTO.stream()
              .map(dto -> new Studente(dto.getNome(), dto.getCognome(), dto.getEmail()))
              .collect(Collectors.toList());

      studenteRepository.saveAll(studenti);
      return studenti;
  }

  public List<Studente> getStudenti() {
      return studenteRepository.findAll();
  }
  
  
  
}
