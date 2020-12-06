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
import my.condominium.model.Directiva;
import my.condominium.service.IDirectivaService;

@RestController
@RequestMapping("/directivas")
public class DirectivaController {

	@Autowired
	private IDirectivaService service;
	
	
	@GetMapping
	public ResponseEntity<List<Directiva>> listar() {
		List<Directiva> lista = service.listar();
		return new ResponseEntity<List<Directiva>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Directiva> listarPorId(@PathVariable("id") Integer id) {
		Directiva obj = service.leerPorId(id);
		
		if(obj.getIdDirectiva() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		return new ResponseEntity<Directiva>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Directiva>> listarPageable(Pageable pageable) {
		Page<Directiva> Directivas = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<Directiva>>(Directivas, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Directiva Directiva) {
		Directiva obj =service.registrar(Directiva);
		
		//pacientes/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdDirectiva()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Directiva> modificar(@Valid @RequestBody Directiva Directiva) {
		Directiva obj = service.modificar(Directiva);
		return new ResponseEntity<Directiva>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {	
		Directiva obj = service.leerPorId(id);
		
		if(obj.getIdDirectiva() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
