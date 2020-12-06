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

import io.swagger.annotations.ApiOperation;
import my.condominium.exception.ModeloNotFoundException;
import my.condominium.model.AreaComun;
import my.condominium.service.IAreaComunService;

@RestController
@RequestMapping("/areascomunes")
public class AreaComunController {

	@Autowired
	private IAreaComunService service;
	
	
	@GetMapping
	@ApiOperation(value = "Returna areas comunes" , response = AreaComun.class)
	public ResponseEntity<List<AreaComun>> listar() {
		List<AreaComun> lista = service.listar();
		return new ResponseEntity<List<AreaComun>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Returna area comun por id" , response = AreaComun.class)
	public ResponseEntity<AreaComun> listarPorId(@PathVariable("id") Integer id) {
		AreaComun obj = service.leerPorId(id);
		
		if(obj.getIdAreaComun() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		return new ResponseEntity<AreaComun>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	@ApiOperation(value = "Returna area comun paginable" , response = AreaComun.class)
	public ResponseEntity<Page<AreaComun>> listarPageable(Pageable pageable) {
		Page<AreaComun> Cargos = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<AreaComun>>(Cargos, HttpStatus.OK);
	}
	
	@PostMapping
	@ApiOperation(value = "Registrar area común" , response = AreaComun.class)
	public ResponseEntity<Object> registrar(@Valid @RequestBody AreaComun areaComun) {
		AreaComun obj =service.registrar(areaComun);
		
		//pacientes/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdAreaComun()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Modifica area común" , response = AreaComun.class)
	public ResponseEntity<AreaComun> modificar(@Valid @RequestBody AreaComun areaComun) {
		AreaComun obj = service.modificar(areaComun);
		return new ResponseEntity<AreaComun>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Elimina area común por id" , response = AreaComun.class)
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {	
		AreaComun obj = service.leerPorId(id);
		
		if(obj.getIdAreaComun() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
