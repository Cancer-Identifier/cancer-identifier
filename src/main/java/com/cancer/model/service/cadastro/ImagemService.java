package com.cancer.model.service.cadastro;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cancer.model.entity.cadastro.Imagem;
import com.cancer.model.repository.cadastro.ImagemRepository;

@Service
public class ImagemService {

    @Autowired
    private ImagemRepository imagemRepository;

    @Transactional
    public void salvarImagem(MultipartFile file) {
        try {
            // Verifique se o arquivo não está vazio
            if (file.isEmpty()) {
                throw new IllegalArgumentException("O arquivo está vazio");
            }

            byte[] imagemBytes = file.getBytes();
            Imagem imagem = new Imagem();
            
            // Obtém o nome original do arquivo
            String nomeArquivo = file.getOriginalFilename();
            imagem.setDescricao(nomeArquivo);
            imagem.setImagem(imagemBytes);
            imagemRepository.save(imagem);
            System.out.println("Imagem salva com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler os bytes da imagem");
        }
    }
    
}

