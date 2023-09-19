package com.cancer.controller.exame;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cancer.model.entity.exame.Exame;
import com.cancer.model.service.cadastro.ImagemService;
import com.google.gson.Gson;

@RestController
public class ExameController {

	@Autowired
	private ExameRepository exameRepository;
	
	@Autowired
    private ImagemService imagemService;
	
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
	public void salvarExame(@RequestBody @Valid @NotNull String json) {
		Exame exame = toJSON(json);
		
		exame.setId(exameRepository.getNextId());
		exameRepository.save(exame);
		
		ResponseEntity.ok();
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
    public ResponseEntity<String> salvarImagem(@RequestParam("file") MultipartFile file) {
        try {
            // Verifique se o arquivo não está vazio
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("O arquivo está vazio");
            }

            imagemService.salvarImagem(file);

            return ResponseEntity.ok("Imagem salva com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar a imagem");
        }
    }
	
	private Exame toJSON(String json) {
		return new Gson().fromJson(json, Exame.class);
	}
	
}
