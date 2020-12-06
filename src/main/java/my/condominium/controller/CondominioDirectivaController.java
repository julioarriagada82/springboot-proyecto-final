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
import my.condominium.model.Condominio;
import my.condominium.service.ICondominioService;

@RestController
@RequestMapping("/condominiosdirectivas")
public class CondominioDirectivaController {

	@Autowired
	private ICondominioService service;
	
	
	@GetMapping
	public ResponseEntity<List<Condominio>> listar() {
		List<Condominio> lista = service.listar();
		return new ResponseEntity<List<Condominio>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Condominio> listarPorId(@PathVariable("id") Integer id) {
		Condominio obj = service.leerPorId(id);
		
		if(obj.getIdCondominio() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		return new ResponseEntity<Condominio>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Condominio>> listarPageable(Pageable pageable) {
		Page<Condominio> Condominios = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<Condominio>>(Condominios, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Condominio Condominio) {
		Condominio obj =service.registrar(Condominio);
		
		//pacientes/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCondominio()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Condominio> modificar(@Valid @RequestBody Condominio Condominio) {
		Condominio obj = service.modificar(Condominio);
		return new ResponseEntity<Condominio>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {	
		Condominio obj = service.leerPorId(id);
		
		if(obj.getIdCondominio() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
