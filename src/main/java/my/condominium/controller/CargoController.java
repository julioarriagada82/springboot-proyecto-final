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
import my.condominium.model.Cargo;
import my.condominium.service.ICargoService;

@RestController
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private ICargoService service;
	
	
	@GetMapping
	public ResponseEntity<List<Cargo>> listar() {
		List<Cargo> lista = service.listar();
		return new ResponseEntity<List<Cargo>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cargo> listarPorId(@PathVariable("id") Integer id) {
		Cargo obj = service.leerPorId(id);
		
		if(obj.getIdCargo() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		return new ResponseEntity<Cargo>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Cargo>> listarPageable(Pageable pageable) {
		Page<Cargo> Cargos = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<Cargo>>(Cargos, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Cargo Cargo) {
		Cargo obj =service.registrar(Cargo);
		
		//pacientes/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCargo()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Cargo> modificar(@Valid @RequestBody Cargo Cargo) {
		Cargo obj = service.modificar(Cargo);
		return new ResponseEntity<Cargo>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {	
		Cargo obj = service.leerPorId(id);
		
		if(obj.getIdCargo() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
