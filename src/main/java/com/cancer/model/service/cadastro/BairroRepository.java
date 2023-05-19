package com.cancer.model.service.cadastro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cancer.model.entity.cadastro.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {
}
