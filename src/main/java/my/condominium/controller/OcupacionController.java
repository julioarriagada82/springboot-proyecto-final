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
import my.condominium.model.Ocupacion;
import my.condominium.service.IOcupacionService;

@RestController
@RequestMapping("/ocupaciones")
public class OcupacionController {

	@Autowired
	private IOcupacionService service;
	
	
	@GetMapping
	public ResponseEntity<List<Ocupacion>> listar() {
		List<Ocupacion> lista = service.listar();
		return new ResponseEntity<List<Ocupacion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ocupacion> listarPorId(@PathVariable("id") Integer id) {
		Ocupacion obj = service.leerPorId(id);
		
		if(obj.getIdOcupacion() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		return new ResponseEntity<Ocupacion>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Ocupacion>> listarPageable(Pageable pageable) {
		Page<Ocupacion> Ocupacions = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<Ocupacion>>(Ocupacions, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Ocupacion Ocupacion) {
		Ocupacion obj =service.registrar(Ocupacion);
		
		//pacientes/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdOcupacion()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Ocupacion> modificar(@Valid @RequestBody Ocupacion Ocupacion) {
		Ocupacion obj = service.modificar(Ocupacion);
		return new ResponseEntity<Ocupacion>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {	
		Ocupacion obj = service.leerPorId(id);
		
		if(obj.getIdOcupacion() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
