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
import my.condominium.model.Casa;
import my.condominium.service.ICasaService;

@RestController
@RequestMapping("/casas")
public class CasaController {

	@Autowired
	private ICasaService service;
	
	
	@GetMapping
	public ResponseEntity<List<Casa>> listar() {
		List<Casa> lista = service.listar();
		return new ResponseEntity<List<Casa>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Casa> listarPorId(@PathVariable("id") Integer id) {
		Casa obj = service.leerPorId(id);
		
		if(obj.getIdCasa() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		return new ResponseEntity<Casa>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Casa>> listarPageable(Pageable pageable) {
		Page<Casa> Casas = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<Casa>>(Casas, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Casa Casa) {
		Casa obj =service.registrar(Casa);
		
		//pacientes/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCasa()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Casa> modificar(@Valid @RequestBody Casa Casa) {
		Casa obj = service.modificar(Casa);
		return new ResponseEntity<Casa>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {	
		Casa obj = service.leerPorId(id);
		
		if(obj.getIdCasa() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
