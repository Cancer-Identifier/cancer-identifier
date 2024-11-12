package com.cancer.controller.exame;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cancer.model.entity.exame.Exame;

@Repository
public interface ExameRepository extends CrudRepository<Exame, Long>, JpaSpecificationExecutor<Exame> {

	@Query("select max(o.id) from Exame o")
	public Long getLastId();
	
	public default Long getNextId() {
		Long lastId = getLastId();
		if(lastId != null)
			return lastId + 1;
		return 1L;
	}
	
    Optional<Exame> findFirstByPacienteId(Long idPaciente);
}
