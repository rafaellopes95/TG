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

import edu.fatec.mural.dao.PaginaDao;
import edu.fatec.mural.model.Pagina;

@RestController
@RequestMapping("/pagina")
public class PaginaController {

	@Autowired
	private PaginaDao paginaDao;

	@RequestMapping(value = "/{id}",
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<Pagina> buscarPagina(@PathVariable("id") int codigo) {
		Pagina pagina = paginaDao.getPagina(codigo);
		
		return new ResponseEntity<>(pagina, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"", "/"},
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<List<Pagina>> listarPaginas() {
		List<Pagina> paginas = paginaDao.listPaginas();
		
		return new ResponseEntity<>(paginas, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"", "/"},
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Pagina> adicionarPagina(@RequestBody Pagina pagina) {
		Pagina paginaAdicionada = paginaDao.addPagina(pagina);
		
		return new ResponseEntity<>(paginaAdicionada, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"", "/"},
			method = RequestMethod.PUT,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Pagina> editarPagina(@RequestBody Pagina pagina) {
		Pagina paginaEditada = paginaDao.editPagina(pagina);
		
		return new ResponseEntity<>(paginaEditada, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"", "/"},
			method = RequestMethod.DELETE,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Pagina> deletarPagina(@RequestBody Pagina pagina) {
		Pagina paginaDeletada = paginaDao.delPagina(pagina);
		
		return new ResponseEntity<>(paginaDeletada, HttpStatus.OK);
	}
}
