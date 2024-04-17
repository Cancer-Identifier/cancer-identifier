package com.cancer.model.repository.cadastro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cancer.model.entity.cadastro.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Long>, JpaRepository<Paciente, Long> {
	
}
