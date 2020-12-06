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
import my.condominium.model.Parentesco;
import my.condominium.service.IParentescoService;

@RestController
@RequestMapping("/parentescos")
public class ParentescoController {

	@Autowired
	private IParentescoService service;
	
	
	@GetMapping
	public ResponseEntity<List<Parentesco>> listar() {
		List<Parentesco> lista = service.listar();
		return new ResponseEntity<List<Parentesco>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Parentesco> listarPorId(@PathVariable("id") Integer id) {
		Parentesco obj = service.leerPorId(id);
		
		if(obj.getIdParentesco() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		return new ResponseEntity<Parentesco>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Parentesco>> listarPageable(Pageable pageable) {
		Page<Parentesco> Parentescos = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<Parentesco>>(Parentescos, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Parentesco Parentesco) {
		Parentesco obj =service.registrar(Parentesco);
		
		//pacientes/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdParentesco()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Parentesco> modificar(@Valid @RequestBody Parentesco Parentesco) {
		Parentesco obj = service.modificar(Parentesco);
		return new ResponseEntity<Parentesco>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {	
		Parentesco obj = service.leerPorId(id);
		
		if(obj.getIdParentesco() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
