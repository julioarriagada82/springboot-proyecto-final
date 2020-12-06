package my.condominium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import my.condominium.model.Ocupacion;
import my.condominium.repo.IOcupacionRepo;
import my.condominium.service.IOcupacionService;

@Service
public class OcupacionServiceImpl implements IOcupacionService {

	@Autowired
	private IOcupacionRepo repo;
	
	@Override
	public Ocupacion registrar(Ocupacion obj) {
		return repo.save(obj);
	}
	
	@Override
	public Ocupacion modificar(Ocupacion obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Ocupacion> listar(){
		return repo.findAll();
	}
	
	@Override
	public Ocupacion leerPorId(Integer id) {
		Optional<Ocupacion> op =  repo.findById(id);
		return op.isPresent() ? op.get() : new Ocupacion();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public Page<Ocupacion> listarPageable(Pageable pageable){
		return repo.findAll(pageable);
	}
}
