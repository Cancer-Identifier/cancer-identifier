package com.cancer.model.service.cadastro;

import com.cancer.model.entity.cadastro.Bairro;
import com.cancer.model.repository.cadastro.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bairroService")
public class BairroService {

    @Autowired
    private BairroRepository bairroRepository;

    public void teste() {
        Bairro bairro = new Bairro();
        bairro.setDescricao("Teste");

        bairroRepository.save(bairro);
    }

}
