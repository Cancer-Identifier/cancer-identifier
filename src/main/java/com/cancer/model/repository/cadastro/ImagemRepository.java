package com.cancer.model.repository.cadastro;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cancer.model.entity.cadastro.Imagem;

@Repository
public interface ImagemRepository  extends JpaRepository<Imagem, Long> {
	
	Optional<Imagem> findById(Long id);
	
}
