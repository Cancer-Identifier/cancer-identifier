package com.cancer.controller.cadastro;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cancer.model.entity.cadastro.Usuario;
import com.cancer.model.repository.cadastro.UsuarioRepository;
import com.google.gson.Gson;

@RestController
public class CadastrarUsuarioController {

	@Autowired private UsuarioRepository usuarioRepository;
	
	@PutMapping(value = "/usuario")
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody @Valid @NotNull String json) {
		Usuario exame = toJSON(json);
		
		usuarioRepository.save(exame);
		return ResponseEntity.ok(exame);
	}
	
	@PutMapping(value = "/usuario/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody @Valid @NotNull String json, 
			@PathVariable @NotNull Long id) {
		Optional<Usuario> optPaciente = usuarioRepository.findById(id);
		if (optPaciente.isEmpty())
			return ResponseEntity.notFound().build();
			
		Usuario exame = toJSON(json);
		exame.setId(id);
		
		usuarioRepository.save(exame);
		return ResponseEntity.ok(exame);
	}
	
	private Usuario toJSON(String json) {
		return new Gson().fromJson(json, Usuario.class);
	}
	
}
