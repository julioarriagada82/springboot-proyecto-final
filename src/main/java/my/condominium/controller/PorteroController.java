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
import my.condominium.model.Portero;
import my.condominium.service.IPorteroService;

@RestController
@RequestMapping("/porteros")
public class PorteroController {

	@Autowired
	private IPorteroService service;
	
	
	@GetMapping
	public ResponseEntity<List<Portero>> listar() {
		List<Portero> lista = service.listar();
		return new ResponseEntity<List<Portero>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Portero> listarPorId(@PathVariable("id") Integer id) {
		Portero obj = service.leerPorId(id);
		
		if(obj.getIdPortero() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		return new ResponseEntity<Portero>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Portero>> listarPageable(Pageable pageable) {
		Page<Portero> Porteros = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<Portero>>(Porteros, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Portero Portero) {
		Portero obj =service.registrar(Portero);
		
		//pacientes/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPortero()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Portero> modificar(@Valid @RequestBody Portero Portero) {
		Portero obj = service.modificar(Portero);
		return new ResponseEntity<Portero>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {	
		Portero obj = service.leerPorId(id);
		
		if(obj.getIdPortero() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
