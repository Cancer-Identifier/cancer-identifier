package com.cancer.model.service.cadastro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cancer.model.entity.cadastro.Paciente;
import com.cancer.model.repository.cadastro.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
    private PacienteRepository pacienteRepository;

	public List<Paciente> pesquisarTodos() {
		List<Paciente> pacienteOpt = pacienteRepository.findAll();
		if (pacienteOpt.isEmpty())
			return new ArrayList<Paciente>();
		
		return pacienteOpt;
	}
	
	public Optional<Paciente> pesquisarPorId(Long id) {
		Optional<Paciente> pacienteOpt = pacienteRepository.findById(id);
		if (pacienteOpt.isEmpty())
			return null;
		
		return pacienteOpt;
	}
	
	
}
