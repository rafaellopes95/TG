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

import edu.fatec.mural.dao.DisciplinaDao;
import edu.fatec.mural.model.Disciplina;

@RestController
@RequestMapping("disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaDao disciplinaDao;
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<Disciplina> buscarDisciplina(@PathVariable("id") String codigo) {
		Disciplina disciplina = disciplinaDao.getDisciplina(codigo);
		
		return new ResponseEntity<>(disciplina, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"", "/"},
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<List<Disciplina>> listarDisciplinas() {
		List<Disciplina> disciplinas = disciplinaDao.listDisciplinas();
		
		return new ResponseEntity<>(disciplinas, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"", "/"},
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Disciplina> adicionarDisciplina(@RequestBody Disciplina disciplina) {
		Disciplina disciplinaAdicionada = disciplinaDao.addDisciplina(disciplina);
		
		return new ResponseEntity<>(disciplinaAdicionada, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"", "/"},
			method = RequestMethod.PUT,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Disciplina> editarDisciplina(@RequestBody Disciplina disciplina) {
		Disciplina disciplinaEditada = disciplinaDao.editDisciplina(disciplina);
		
		return new ResponseEntity<>(disciplinaEditada, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"", "/"},
			method = RequestMethod.DELETE,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Disciplina> deletarDisciplina(@RequestBody Disciplina disciplina) {
		Disciplina disciplinaDeletada = disciplinaDao.delDisciplina(disciplina);
		
		return new ResponseEntity<>(disciplinaDeletada, HttpStatus.OK);
	}
}
