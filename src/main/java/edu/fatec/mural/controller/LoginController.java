package edu.fatec.mural.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.fatec.mural.dao.UsuarioDao;
import edu.fatec.mural.model.Usuario;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@RequestMapping(value = "/",
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Usuario> loginUsuario(@RequestBody Usuario usuario) {
		
		usuario = usuarioDao.getUsuario(usuario.getUsername(), usuario.getPassword());
		
		System.out.println(usuario.getUsername() + " " + usuario.getPassword());
		
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
}
