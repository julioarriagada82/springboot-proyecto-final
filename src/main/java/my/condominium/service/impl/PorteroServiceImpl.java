package my.condominium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import my.condominium.model.Portero;
import my.condominium.repo.IPorteroRepo;
import my.condominium.service.IPorteroService;

@Service
public class PorteroServiceImpl implements IPorteroService {

	@Autowired
	private IPorteroRepo repo;
	
	@Override
	public Portero registrar(Portero obj) {
		return repo.save(obj);
	}
	
	@Override
	public Portero modificar(Portero obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Portero> listar(){
		return repo.findAll();
	}
	
	@Override
	public Portero leerPorId(Integer id) {
		Optional<Portero> op =  repo.findById(id);
		return op.isPresent() ? op.get() : new Portero();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public Page<Portero> listarPageable(Pageable pageable){
		return repo.findAll(pageable);
	}
}
