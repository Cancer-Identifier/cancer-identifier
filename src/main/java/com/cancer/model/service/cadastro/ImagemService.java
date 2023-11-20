package com.cancer.model.service.cadastro;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cancer.model.entity.cadastro.Imagem;
import com.cancer.model.entity.exame.Exame;
import com.cancer.model.repository.cadastro.ImagemRepository;

@Service
public class ImagemService {

    @Autowired
    private ImagemRepository imagemRepository;
    
    public void salvarImagem(byte[] file) {
    	Imagem imagem = new Imagem();
    	
        imagem.setArquivo(file);
        
        imagemRepository.save(imagem);
    }

    @Transactional
    public void salvarImagem(MultipartFile file, Exame exame) {
        try {
            byte[] imagemBytes = file.getBytes();
            
            Imagem imagem = new Imagem();
            
            // Obtém o nome original do arquivo
            String nomeArquivo = file.getOriginalFilename();
            imagem.setDescricao(nomeArquivo);
            imagem.setArquivo(imagemBytes);
            imagem.setExame(exame);
            
            imagemRepository.save(imagem);
            System.out.println("Imagem salva com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler os bytes da imagem");
        }
    }
    
}

