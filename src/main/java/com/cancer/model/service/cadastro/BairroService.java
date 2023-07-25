package com.cancer.model.service.cadastro;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cancer.model.entity.cadastro.Bairro;
import com.cancer.model.repository.cadastro.BairroRepository;

@Service
public class BairroService {

	@Autowired
    private BairroRepository bairroRepository;

	public void salvarBairro(String nome) {
        Bairro bairro = new Bairro();
        bairro.setDescricao(nome);

        bairroRepository.save(bairro);
    }
	
	public void editarBairro(Optional<Bairro> pesquisa) {
		Bairro bairro = new Bairro();
		bairro.setId(pesquisa.get().getId());
		bairro.setDescricao(pesquisa.get().getDescricao());
		
		bairroRepository.save(bairro);
		
	}
	
	public Optional<Bairro> pesquisarPorId(Long id) {
		return bairroRepository.findById(id);
	}
	
	public void deletarPorId(Long id) {
		bairroRepository.deleteById(id);
	}

}
