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
import my.condominium.model.TipoCondominio;
import my.condominium.service.ITipoCondominioService;

@RestController
@RequestMapping("/tiposcondominios")
public class TipoCondominioController {

	@Autowired
	private ITipoCondominioService service;
	
	
	@GetMapping
	public ResponseEntity<List<TipoCondominio>> listar() {
		List<TipoCondominio> lista = service.listar();
		return new ResponseEntity<List<TipoCondominio>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoCondominio> listarPorId(@PathVariable("id") Integer id) {
		TipoCondominio obj = service.leerPorId(id);
		
		if(obj.getIdTipoCondominio() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		return new ResponseEntity<TipoCondominio>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<TipoCondominio>> listarPageable(Pageable pageable) {
		Page<TipoCondominio> TipoCondominios = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<TipoCondominio>>(TipoCondominios, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody TipoCondominio TipoCondominio) {
		TipoCondominio obj =service.registrar(TipoCondominio);
		
		//pacientes/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipoCondominio()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<TipoCondominio> modificar(@Valid @RequestBody TipoCondominio TipoCondominio) {
		TipoCondominio obj = service.modificar(TipoCondominio);
		return new ResponseEntity<TipoCondominio>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {	
		TipoCondominio obj = service.leerPorId(id);
		
		if(obj.getIdTipoCondominio() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
