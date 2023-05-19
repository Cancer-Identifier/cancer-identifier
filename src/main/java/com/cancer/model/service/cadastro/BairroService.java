package com.cancer.model.service.cadastro;

import com.cancer.model.entity.cadastro.Bairro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bairroService")
public class BairroService {

    @Autowired
    private BairroRepository bairroRepository;

    public void test() {
        Bairro bairro = new Bairro();
        bairro.setDescricao("Gabriel");

        bairroRepository.save(bairro);
    }

}
