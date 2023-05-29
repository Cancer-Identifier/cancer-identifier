package com.cancer.model.service.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cancer.model.entity.cadastro.Bairro;
import com.cancer.model.repository.cadastro.BairroRepository;

@Service
public class BairroService {

	@Autowired
    private BairroRepository bairroRepository;

    public void salvarBairro(Bairro bairro) {
        bairroRepository.save(bairro);
    }

}
