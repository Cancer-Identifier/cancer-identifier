package com.cancer.controller.cadastro;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cancer.model.entity.cadastro.Paciente;
import com.cancer.model.repository.cadastro.PacienteRepository;
import com.google.gson.Gson;

@RestController
public class CadastrarPacienteController {

	@Autowired private PacienteRepository pacienteRepository;
	
	@PutMapping(value = "/paciente")
	public ResponseEntity<Paciente> salvarPaciente(@RequestBody @Valid @NotNull String json) {
		Paciente exame = toJSON(json);
		
		pacienteRepository.save(exame);
		return ResponseEntity.ok(exame);
	}
	
	@PutMapping(value = "/paciente/{id}")
	public ResponseEntity<Paciente> atualizarPaciente(@RequestBody @Valid @NotNull String json, 
			@PathVariable @NotNull Long id) {
		Optional<Paciente> optPaciente = pacienteRepository.findById(id);
		if (optPaciente.isEmpty())
			return ResponseEntity.notFound().build();
			
		Paciente exame = toJSON(json);
		exame.setId(id);
		
		pacienteRepository.save(exame);
		return ResponseEntity.ok(exame);
	}
	
	@GetMapping(value = "/paciente/{id}")
	public ResponseEntity<Paciente> pesquisarUsuario(@PathVariable @NotNull Long id) {
		Optional<Paciente> optPaciente = pacienteRepository.findById(id);
		if (optPaciente.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(optPaciente.get());
	}
	
	@GetMapping(value = "/paciente")
	public ResponseEntity<List<Paciente>> pesquisarTodosPacientes() {
		List<Paciente> listPacientes = pacienteRepository.findAll();
		if (listPacientes.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(listPacientes);
	}
	
	private Paciente toJSON(String json) {
		return new Gson().fromJson(json, Paciente.class);
	}
	
}
