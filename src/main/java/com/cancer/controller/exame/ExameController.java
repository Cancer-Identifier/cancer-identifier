package com.cancer.controller.exame;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class ExameController {

	@Autowired
	private ExameRepository exameRepository;
	
	@PutMapping(value = "/exame/{id}")
	public void atualizarExame(@PathVariable Long id) {
		Optional<Exame> optExame = exameRepository.findById(id);
		if (optExame.isEmpty())
			return;
		
		exameRepository.save(optExame.get());
		System.out.println("Registro salvo com sucesso!");
	}
	
	@PostMapping(value = "/exame")
	public void salvarExame(@RequestBody String json) {
		Exame exame = toJSON(json);
		
		exame.setId(exameRepository.getNextId());
		exameRepository.save(exame);
		
		System.out.println(ResponseEntity.ok());
	}
	
	@GetMapping(value = "/exame/{id}")
	public void pesquisarExame(@PathVariable Long id) {
		Optional<Exame> optExame = exameRepository.findById(id);
		Exame exame = optExame.get();
		System.out.println(exame.getDescricao());
	}
	
	@DeleteMapping(value = "/exame/{id}")
	public void deletarExame(@PathVariable Long id) {
		Optional<Exame> optExame = exameRepository.findById(id);
		if (optExame.isEmpty())
			return;
		
		exameRepository.delete(optExame.get());
		System.out.println("Registro excluido com sucesso!");
	}
	
	private Exame toJSON(String json) {
		return new Gson().fromJson(json, Exame.class);
	}
	
}
