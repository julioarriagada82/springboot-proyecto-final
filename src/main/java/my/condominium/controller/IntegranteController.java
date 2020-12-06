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
import my.condominium.model.Integrante;
import my.condominium.service.IIntegranteService;


@RestController
@RequestMapping("/integrantes")
public class IntegranteController {

	@Autowired
	private IIntegranteService service;
	
	
	@GetMapping
	public ResponseEntity<List<Integrante>> listar() {
		List<Integrante> lista = service.listar();
		return new ResponseEntity<List<Integrante>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Integrante> listarPorId(@PathVariable("id") Integer id) {
		Integrante obj = service.leerPorId(id);
		
		if(obj.getIdIntegrante() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		return new ResponseEntity<Integrante>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Integrante>> listarPageable(Pageable pageable) {
		Page<Integrante> Integrantes = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<Integrante>>(Integrantes, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Integrante Integrante) {
		Integrante obj =service.registrar(Integrante);
		
		//pacientes/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdIntegrante()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Integrante> modificar(@Valid @RequestBody Integrante Integrante) {
		Integrante obj = service.modificar(Integrante);
		return new ResponseEntity<Integrante>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {	
		Integrante obj = service.leerPorId(id);
		
		if(obj.getIdIntegrante() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
