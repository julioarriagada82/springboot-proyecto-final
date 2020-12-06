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
import my.condominium.model.HorarioTurno;
import my.condominium.service.IHorarioTurnoService;

@RestController
@RequestMapping("/horariosturnos")
public class HorarioTurnoController {

	@Autowired
	private IHorarioTurnoService service;
	
	
	@GetMapping
	public ResponseEntity<List<HorarioTurno>> listar() {
		List<HorarioTurno> lista = service.listar();
		return new ResponseEntity<List<HorarioTurno>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HorarioTurno> listarPorId(@PathVariable("id") Integer id) {
		HorarioTurno obj = service.leerPorId(id);
		
		if(obj.getIdHorarioTurno() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		return new ResponseEntity<HorarioTurno>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<HorarioTurno>> listarPageable(Pageable pageable) {
		Page<HorarioTurno> HorarioTurnos = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<HorarioTurno>>(HorarioTurnos, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody HorarioTurno horarioTurno) {
		HorarioTurno obj = service.registrar(horarioTurno);
		
		//pacientes/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdHorarioTurno()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<HorarioTurno> modificar(@Valid @RequestBody HorarioTurno horarioTurno) {
		HorarioTurno obj = service.modificar(horarioTurno);
		return new ResponseEntity<HorarioTurno>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {	
		HorarioTurno obj = service.leerPorId(id);
		
		if(obj.getIdHorarioTurno() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
