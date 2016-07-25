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

import edu.fatec.mural.dao.PublicacaoDao;
import edu.fatec.mural.model.Publicacao;

@RestController
@RequestMapping("/publicacao")
public class PublicacaoController {

	@Autowired
	private PublicacaoDao publicacaoDao;
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<Publicacao> buscarpublicacao(@PathVariable("id") int codigo) {
		Publicacao publicacao = publicacaoDao.getPublicacao(codigo);
		
		return new ResponseEntity<>(publicacao, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"", "/"},
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<List<Publicacao>> listarpublicacaos() {
		List<Publicacao> publicacaos = publicacaoDao.listPublicacoes();
		
		return new ResponseEntity<>(publicacaos, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"", "/"},
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Publicacao> adicionarpublicacao(@RequestBody Publicacao publicacao) {
		Publicacao publicacaoAdicionada = publicacaoDao.addPublicacao(publicacao);
		
		return new ResponseEntity<>(publicacaoAdicionada, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"", "/"},
			method = RequestMethod.PUT,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Publicacao> editarpublicacao(@RequestBody Publicacao publicacao) {
		Publicacao publicacaoEditada = publicacaoDao.editPublicacao(publicacao);
		
		return new ResponseEntity<>(publicacaoEditada, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"", "/"},
			method = RequestMethod.DELETE,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Publicacao> deletarpublicacao(@RequestBody Publicacao publicacao) {
		Publicacao publicacaoDeletada = publicacaoDao.delPublicacao(publicacao);
		
		return new ResponseEntity<>(publicacaoDeletada, HttpStatus.OK);
	}
}
