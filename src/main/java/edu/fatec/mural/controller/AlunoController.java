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

import edu.fatec.mural.dao.AlunoDao;
import edu.fatec.mural.model.Aluno;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoDao alunoDao;
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<Aluno> buscarAluno(@PathVariable("id") String ra) {
		Aluno aluno = alunoDao.getAluno(ra);
		
		return new ResponseEntity<>(aluno, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/", ""},
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<List<Aluno>> listarAlunos() {
		List<Aluno> alunos = alunoDao.listAlunos();
		
		return new ResponseEntity<>(alunos, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/", ""},
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Aluno> adicionarAluno(@RequestBody Aluno aluno) {
		Aluno alunoAdicionado = alunoDao.addAluno(aluno);
		
		return new ResponseEntity<>(alunoAdicionado, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/", ""},
			method = RequestMethod.PUT,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Aluno> editarAluno(@RequestBody Aluno aluno) {
		Aluno alunoEditado = alunoDao.editAluno(aluno);
		
		return new ResponseEntity<>(alunoEditado, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/", ""},
			method = RequestMethod.DELETE,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Aluno> deletarAluno(@RequestBody Aluno aluno) {
		
		System.out.println(aluno.getNome());
		
		Aluno alunoDeletado = alunoDao.delAluno(aluno);
		
		return new ResponseEntity<>(alunoDeletado, HttpStatus.OK);
	}
	
	
}
