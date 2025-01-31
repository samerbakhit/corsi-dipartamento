package com.samer.dbCrud.Controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.samer.dbCrud.Model.Studenti;
import com.samer.dbCrud.Service.StudentiServizi;

import jakarta.validation.Valid;

@Controller
@RequestMapping("studenti")
public class StudentiController {
	
	@Autowired
	StudentiServizi ss;
	
	@GetMapping({"","/"})
	public String testIndex(Model model) {
		long count =(long)(ss.countStudenti());
		System.out.println(count);
		model.addAttribute("count", count);
		
		return ("index");
		
	}
	@GetMapping("/allStudenti")
	public String StampaAllStudenti(Model model) {
		ArrayList<Studenti>listaStudenti = (ArrayList<Studenti>) ss.getALlStudenti();
		model.addAttribute("listaStudenti", listaStudenti);
	return ("studenti/studenti");
	}
	@GetMapping("newStudente")
	public String newStudente (Model model) {
		
		model.addAttribute("studente",new Studenti());
		return "studenti/studenti-form";
		}
	
	@GetMapping("/edit/{id}")
	public String getStudentiById (@PathVariable Long id,Model model) {
		Studenti studente = ss.getStudenteById(id);
		model.addAttribute("studente", studente);
		return "studenti/studenti-form";
		}
	@GetMapping("/delete/{id}")
	public String deleteStudentiById(@PathVariable Long id) {
		ss.deleteStudente(id);
		return "redirect:/studenti/allStudenti";
	}
	


	
	
	
	@PostMapping("/save")
	public String updateStudente(@Valid @ModelAttribute("studente") Studenti studente,
    		BindingResult result,
    		Model model) {
		 if (result.hasErrors()) {
	            return "studenti/studenti-form";  // Ritorna al form se ci sono errori di validazione
	        }
	       
	    	model.addAttribute("studente", studente);
	        ss.saveStudente(studente);
	        return "redirect:/studenti/allStudenti";
	}
	
}
