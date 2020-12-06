package my.condominium.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import my.condominium.exception.ModeloNotFoundException;
import my.condominium.model.ListaNegra;
import my.condominium.service.IListaNegraService;

@RestController
@RequestMapping("/listasnegras")
public class ListaNegraController {

	@Autowired
	private IListaNegraService service;
	
	
	@GetMapping
	public ResponseEntity<List<ListaNegra>> listar() {
		List<ListaNegra> lista = service.listar();
		return new ResponseEntity<List<ListaNegra>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ListaNegra> listarPorId(@PathVariable("id") Integer id) {
		ListaNegra obj = service.leerPorId(id);
		
		if(obj.getIdListaNegra() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		return new ResponseEntity<ListaNegra>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<ListaNegra>> listarPageable(Pageable pageable) {
		Page<ListaNegra> ListaNegras = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<ListaNegra>>(ListaNegras, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody ListaNegra listaNegra) {
		ListaNegra obj =service.registrar(listaNegra);
		
		//pacientes/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdListaNegra()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<ListaNegra> modificar(@Valid @RequestBody ListaNegra listaNegra) {
		ListaNegra obj = service.modificar(listaNegra);
		return new ResponseEntity<ListaNegra>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {	
		ListaNegra obj = service.leerPorId(id);
		
		if(obj.getIdListaNegra() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
