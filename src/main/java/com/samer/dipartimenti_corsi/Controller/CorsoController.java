package com.samer.dipartimenti_corsi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samer.dipartimenti_corsi.DTO.CorsoDTO;
import com.samer.dipartimenti_corsi.DTO.StudenteDTO;
import com.samer.dipartimenti_corsi.models.Corso;
import com.samer.dipartimenti_corsi.servizi.CorsoService;
import com.samer.dipartimenti_corsi.servizi.DipartimentoServizi;
import com.samer.dipartimenti_corsi.servizi.StudenteService;

@RestController
@RequestMapping("/api/corsi")
public class CorsoController {
	@Autowired
	StudenteService ss;
	@Autowired
	CorsoService cs;
	@Autowired
	DipartimentoServizi ds;
	
	@GetMapping("/listacorsi")
	public List<Corso>showall(){
		return cs.findAllCorsi();
		
	}
	
	@GetMapping("/{id}")
	public Corso findCorsoById(@PathVariable Long id) {
		return cs.findCorsoByID(id);
	}
	
	@DeleteMapping("/{id}")
	public String cancellaCorso(@PathVariable Long id) {
		if(cs.esisteCorsoById(id)) {
		cs.deleteCorsoById(id);
		
		return "Corso con id: "+id+" e stato cancellato";
		}else {
			return "Corso con id: "+id+" non esiste";
		}
	}
	
	@PostMapping("/nuovocorso")
	public String nuovoCorso(@RequestBody CorsoDTO corsoDto) {
		 cs.addNewCorso(corsoDto);
		 return " Il corso "+corsoDto.getNome()+" e stato aggiunto con sucesso";
	}
	@PutMapping("/{id}")
	public String updateCorsoById(@PathVariable Long id,@RequestBody CorsoDTO corsoDto) {
		
		cs.updateCorso(corsoDto, id);
		return " Il corso "+corsoDto.getNome()+" e stato aggiornato con sucesso"; 
	}
	@GetMapping("/studenti")
	public List<StudenteDTO> getStudenti() {
        return ss.getStudentiFromMicroservizio();
    }

}
