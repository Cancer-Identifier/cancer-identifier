package com.cancer.controller.exame;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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
}
