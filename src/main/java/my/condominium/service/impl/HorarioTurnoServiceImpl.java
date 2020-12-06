package my.condominium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import my.condominium.model.HorarioTurno;
import my.condominium.repo.IHorarioTurnoRepo;
import my.condominium.service.IHorarioTurnoService;

@Service
public class HorarioTurnoServiceImpl implements IHorarioTurnoService {

	@Autowired
	private IHorarioTurnoRepo repo;
	
	@Override
	public HorarioTurno registrar(HorarioTurno obj) {
		return repo.save(obj);
	}
	
	@Override
	public HorarioTurno modificar(HorarioTurno obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<HorarioTurno> listar(){
		return repo.findAll();
	}
	
	@Override
	public HorarioTurno leerPorId(Integer id) {
		Optional<HorarioTurno> op =  repo.findById(id);
		return op.isPresent() ? op.get() : new HorarioTurno();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public Page<HorarioTurno> listarPageable(Pageable pageable){
		return repo.findAll(pageable);
	}
}
