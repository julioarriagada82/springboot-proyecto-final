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
import my.condominium.model.PeriodoHorario;
import my.condominium.service.IPeriodoHorarioService;

@RestController
@RequestMapping("/periodoshorarios")
public class PeriodoHorarioController {

	@Autowired
	private IPeriodoHorarioService service;
	
	
	@GetMapping
	public ResponseEntity<List<PeriodoHorario>> listar() {
		List<PeriodoHorario> lista = service.listar();
		return new ResponseEntity<List<PeriodoHorario>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PeriodoHorario> listarPorId(@PathVariable("id") Integer id) {
		PeriodoHorario obj = service.leerPorId(id);
		
		if(obj.getIdPeriodoHorario() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		return new ResponseEntity<PeriodoHorario>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<PeriodoHorario>> listarPageable(Pageable pageable) {
		Page<PeriodoHorario> PeriodoHorarios = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<PeriodoHorario>>(PeriodoHorarios, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody PeriodoHorario PeriodoHorario) {
		PeriodoHorario obj =service.registrar(PeriodoHorario);
		
		//pacientes/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPeriodoHorario()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<PeriodoHorario> modificar(@Valid @RequestBody PeriodoHorario PeriodoHorario) {
		PeriodoHorario obj = service.modificar(PeriodoHorario);
		return new ResponseEntity<PeriodoHorario>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {	
		PeriodoHorario obj = service.leerPorId(id);
		
		if(obj.getIdPeriodoHorario() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
