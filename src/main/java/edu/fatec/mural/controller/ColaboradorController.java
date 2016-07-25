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

import edu.fatec.mural.dao.ColaboradorDao;
import edu.fatec.mural.model.Colaborador;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

	@Autowired
	private ColaboradorDao colaboradorDao;
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<Colaborador> buscarColaborador(@PathVariable("id") String codigo) {
		
		Colaborador colaborador = colaboradorDao.getColaborador(codigo);
		
		return new ResponseEntity<>(colaborador, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"", "/"},
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<List<Colaborador>> listarColaboradores() {
		List<Colaborador> colaboradores = colaboradorDao.listColaboradores();
		
		return new ResponseEntity<>(colaboradores, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"", "/"},
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Colaborador> adicionarColaborador(@RequestBody Colaborador colaborador) {
		Colaborador colaboradorAdicionado = colaboradorDao.addColaborador(colaborador);
		
		return new ResponseEntity<>(colaboradorAdicionado, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"", "/"},
			method = RequestMethod.PUT,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Colaborador> editarColaborador(@RequestBody Colaborador colaborador) {
		Colaborador colaboradorEditado = colaboradorDao.editColaborador(colaborador);
		
		return new ResponseEntity<>(colaboradorEditado, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"", "/"},
			method = RequestMethod.DELETE,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Colaborador> deletarColaborador(@RequestBody Colaborador colaborador) {
		Colaborador colaboradorDeletado = colaboradorDao.delColaborador(colaborador);
		
		return new ResponseEntity<>(colaboradorDeletado, HttpStatus.OK);
	}
}
