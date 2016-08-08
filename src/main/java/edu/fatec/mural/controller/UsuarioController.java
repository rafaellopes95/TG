package edu.fatec.mural.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.fatec.mural.dao.UsuarioDao;
import edu.fatec.mural.model.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@RequestMapping(value = "/{id}/{pass}",
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<Usuario> buscarUsuario(@PathVariable("id") String username, @PathVariable("pass") String password) {
		Usuario usuario = usuarioDao.getUsuario(username, password);
		
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/", ""},
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		List<Usuario> usuarios = usuarioDao.listUsuarios();
		
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/", ""},
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Usuario> adicionarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioAdicionado = usuarioDao.addUsuario(usuario);
		
		return new ResponseEntity<>(usuarioAdicionado, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/", ""},
			method = RequestMethod.PUT,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioEditado = usuarioDao.editUsuario(usuario);
		
		return new ResponseEntity<>(usuarioEditado, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/", ""},
			method = RequestMethod.DELETE,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Usuario> deletarUsuario(@RequestBody Usuario usuario) {
				
		Usuario usuarioDeletado = usuarioDao.delUsuario(usuario);
		
		return new ResponseEntity<>(usuarioDeletado, HttpStatus.OK);
	}
	
	

}
