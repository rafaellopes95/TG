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

import edu.fatec.mural.dao.CursoDao;
import edu.fatec.mural.model.Curso;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoDao cursoDao;
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<Curso> buscarCurso(@PathVariable("id") String sigla) {
		Curso curso = cursoDao.getCurso(sigla);
		
		return new ResponseEntity<>(curso, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/", ""}, 
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<List<Curso>> listarCursos() {
		List<Curso> cursos = cursoDao.listCursos();
		
		return new ResponseEntity<>(cursos, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/", ""},
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Curso> adicionarCurso(@RequestBody Curso curso) {
		Curso cursoAdicionado = cursoDao.addCurso(curso);
		
		return new ResponseEntity<>(cursoAdicionado, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/", ""},
			method = RequestMethod.PUT,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Curso> editarCurso(@RequestBody Curso curso) {
		Curso cursoEditado = cursoDao.editCurso(curso);
		
		return new ResponseEntity<>(cursoEditado, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/", ""},
			method = RequestMethod.DELETE,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Curso> deletarCurso(@RequestBody Curso curso) {
		Curso cursoDeletado = cursoDao.delCurso(curso);
		
		return new ResponseEntity<>(cursoDeletado, HttpStatus.OK);
	}
}
