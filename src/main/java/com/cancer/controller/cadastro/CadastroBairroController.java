package com.cancer.controller.cadastro;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cancer.model.entity.cadastro.Bairro;
import com.cancer.model.service.cadastro.BairroService;

@Controller
public class CadastroBairroController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	BairroService bairroService;
	
	public void salvarBairro(String nome) {
        Bairro bairro = new Bairro();
        bairro.setDescricao(nome);

        bairroService.salvarBairro(bairro);
    }
}
