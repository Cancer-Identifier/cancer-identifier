package com.cancer.model.service.cadastro;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cancer.controller.exame.ExameRepository;
import com.cancer.model.entity.cadastro.Paciente;
import com.cancer.model.entity.exame.Exame;

@Service
public class ExameService {

	@Autowired
	private ExameRepository exameRepository;

	@Autowired
	private PacienteService pacienteService;

	public void salvarExame(Long idpaciente, String descricao, LocalDate data) {
		Optional<Paciente> paciente = pacienteService.pesquisarPorId(idpaciente);

		Exame exame = new Exame();
		exame.setDescricao(descricao);
		exame.setDataExames(data);
		exame.setPaciente(paciente.get());
		exame.setId(exameRepository.getNextId());

		exameRepository.save(exame);
	}

	public Optional<Exame> pesquisaExamePorPaciente(Long idPaciente) {
        Optional<Paciente> paciente = pacienteService.pesquisarPorId(idPaciente);
        if (paciente.isPresent()) {
            return exameRepository.findFirstByPacienteId(idPaciente);
        } else {
            throw new RuntimeException("Paciente não encontrado para o ID fornecido: " + idPaciente);
        }
    }

}
