package com.samer.dipartimenti_corsi.servizi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.samer.dipartimenti_corsi.DTO.StudenteDTO;

import java.util.Arrays;
import java.util.List;

@Service
public class StudenteService {
	@Autowired
    RestTemplate restTemplate;

 

    public List<StudenteDTO> getStudentiFromMicroservizio() {
        String url = "http://localhost:8082/api/studenti/listastudenti"; // URL dell'API esistente nel progetto Studenti
        ResponseEntity<StudenteDTO[]> response = restTemplate.getForEntity(url, StudenteDTO[].class);
        return Arrays.asList(response.getBody());
    }
}
