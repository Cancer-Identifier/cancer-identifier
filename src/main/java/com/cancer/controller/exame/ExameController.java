package com.cancer.controller.exame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.cancer.model.entity.cadastro.Imagem;
import com.cancer.model.entity.exame.Exame;
import com.cancer.model.repository.cadastro.ImagemDTO;
import com.cancer.model.repository.cadastro.ImagemRepository;
import com.cancer.model.service.cadastro.ImagemService;
import com.google.gson.Gson;

@RestController
public class ExameController {

	@Autowired
	private ExameRepository exameRepository;
	
	@Autowired
    private ImagemService imagemService;
	
	@Autowired
	private ImagemRepository imagemRepository;
	
	@PutMapping(value = "/exame/{id}")
	public ResponseEntity<Exame> atualizarExame(
			@RequestBody @Valid @NotNull String json, @PathVariable("id") @NotNull Long id) {
		Optional<Exame> optExame = exameRepository.findById(id);
		if (optExame.isEmpty())
			return ResponseEntity.notFound().build();
		
		Exame exame = toJSON(json);
		
		exame.setId(optExame.get().getId());
		
		exameRepository.save(exame);
		return ResponseEntity.ok(exame);
	}
	
	@PostMapping(value = "/exame")
	public ResponseEntity<Exame> salvarExame(@RequestBody @Valid @NotNull String json) {
		Exame exame = toJSON(json);
		
		exame.setId(exameRepository.getNextId());
		exameRepository.save(exame);
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/exame/{id}")
	public ResponseEntity<Exame> pesquisarExame(@PathVariable("id") @NotNull Long id) {
		Optional<Exame> optExame = exameRepository.findById(id);
		
		return ResponseEntity.of(optExame);
	}
	
	@DeleteMapping(value = "/exame/{id}")
	public ResponseEntity<Exame> deletarExame(@PathVariable("id") @NotNull Long id) {
		Optional<Exame> optExame = exameRepository.findById(id);
		if (optExame.isEmpty())
			return ResponseEntity.notFound().build();
		
		exameRepository.delete(optExame.get());
		return ResponseEntity.ok().build();
	}
	
	@PostMapping(value = "/imagem")
    public ResponseEntity<String> salvarImagem(@RequestParam("file") @NotNull MultipartFile file, @RequestParam("text") @NotNull String json) {
        try {
            System.out.println(file.getName() + "  " + json);
            
            Exame exame = toJSON(json);
            exame.setTipoExame(null);
            exame.setId(exameRepository.getNextId());
            exameRepository.save(exame);
            
            imagemService.salvarImagem(file, exame);

            return ResponseEntity.ok("Imagem salva com sucesso");
        } catch (Exception e) {
        	return ResponseEntity.status(500).body("Erro ao salvar a imagem: " + e.getMessage());
        }
    }
	
	@PostMapping(value = "/somente_imagem")
	public ResponseEntity<String> salvarImagem(@RequestBody @NotNull byte[] file) {
		try {
			if (file == null)
				throw new Exception("DEu ruim");
			
			imagemService.salvarImagem(file);
			
			return ResponseEntity.ok("Imagem salva com sucesso");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro ao salvar a imagem: " + e.getMessage());
		}
	}
	
	@PostMapping(value = "/enviarImagem")
    public ResponseEntity<String> enviarIamgem(@RequestBody @NotNull byte[] file) {
        try {
            if (file == null)
                throw new Exception("Deu ruim");

            imagemService.salvarImagem(file);

            // Enviar a imagem para o endpoint Python
            final String uri = "http://localhost:5000/receberImagem"; // Substitua pela URL do seu endpoint Python
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", new ByteArrayResource(file));
            
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
            
            RestTemplate restTemplate = new RestTemplate();
            
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri, requestEntity, String.class);
            
            // Verificar a resposta do endpoint Python
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return ResponseEntity.ok("Imagem salva com sucesso e enviada para o endpoint Python");
            } else {
                return ResponseEntity.status(500).body("Erro ao enviar a imagem para o endpoint Python");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao salvar a imagem: " + e.getMessage());
        }
    }
	
	@GetMapping("/imagem/{id}")
    public ResponseEntity<byte[]> getImagem(@PathVariable @NotNull @Valid Long id) {
        Optional<Imagem> imagemOptional = imagemRepository.findById(id);
        if (imagemOptional.isEmpty())
        	return ResponseEntity.notFound().build();
        
    	byte[] imagemBytes = imagemOptional.get().getArquivo();
    	return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagemBytes);
    }
    
    
    @GetMapping("/pesquisa")
    public ResponseEntity<List<ImagemDTO>> pesquisarTodasImagens() {
        List<Imagem> imagens = imagemRepository.findAll();

        List<ImagemDTO> imagensDTO = new ArrayList<>();
        for (Imagem imagem : imagens) {
            ImagemDTO imagemDTO = new ImagemDTO();
            imagemDTO.setId(imagem.getId());
            imagemDTO.setDescricao(imagem.getDescricao());
            imagensDTO.add(imagemDTO);
        }

        return ResponseEntity.ok(imagensDTO);
    }


	
	private Exame toJSON(String json) {
		return new Gson().fromJson(json, Exame.class);
	}
	
}
