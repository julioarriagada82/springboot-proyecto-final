package my.condominium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import my.condominium.model.PorteroTurno;
import my.condominium.repo.IPorteroTurnoRepo;
import my.condominium.service.IPorteroTurnoService;

@Service
public class PorteroTurnoServiceImpl implements IPorteroTurnoService {

	@Autowired
	private IPorteroTurnoRepo repo;
	
	@Override
	public PorteroTurno registrar(PorteroTurno obj) {
		return repo.save(obj);
	}
	
	@Override
	public PorteroTurno modificar(PorteroTurno obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<PorteroTurno> listar(){
		return repo.findAll();
	}
	
	@Override
	public PorteroTurno leerPorId(Integer id) {
		Optional<PorteroTurno> op =  repo.findById(id);
		return op.isPresent() ? op.get() : new PorteroTurno();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public Page<PorteroTurno> listarPageable(Pageable pageable){
		return repo.findAll(pageable);
	}
}
