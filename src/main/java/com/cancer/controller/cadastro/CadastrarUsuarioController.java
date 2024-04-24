package com.cancer.controller.cadastro;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		Usuario usuario = toJSON(json);
		
		usuarioRepository.save(usuario);
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping(value = "/usuario/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody @Valid @NotNull String json, 
			@PathVariable @NotNull Long id) {
		Optional<Usuario> optPaciente = usuarioRepository.findById(id);
		if (optPaciente.isEmpty())
			return ResponseEntity.notFound().build();
			
		Usuario usuario = toJSON(json);
		usuario.setId(id);
		
		usuarioRepository.save(usuario);
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping(value = "/usuario/{id}")
	public ResponseEntity<Usuario> pesquisarUsuario(@PathVariable @NotNull Long id) {
		Optional<Usuario> optPaciente = usuarioRepository.findById(id);
		if (optPaciente.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(optPaciente.get());
	}
	
	@GetMapping(value = "/usuario")
	public ResponseEntity<List<Usuario>> pesquisarTodosUsuarios() {
		List<Usuario> listPacientes = usuarioRepository.findAll();
		if (listPacientes.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(listPacientes);
	} 
	
	 @PostMapping("/login")
	 public ResponseEntity<Boolean> login(@RequestBody @Valid @NotNull  String loginRequest) {
        // Verifica se o email e a senha correspondem a um registro no banco de dados
		Usuario usuarioJson = toJSON(loginRequest);
        Usuario usuario = usuarioRepository.findByEmailAndSenha(usuarioJson.getEmail(), usuarioJson.getSenha());
        if (usuario != null) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
	  }
	
	private Usuario toJSON(String json) {
		return new Gson().fromJson(json, Usuario.class);
	}
	
}
