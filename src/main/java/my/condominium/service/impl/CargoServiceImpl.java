package my.condominium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import my.condominium.model.Cargo;
import my.condominium.repo.ICargoRepo;
import my.condominium.service.ICargoService;

@Service
public class CargoServiceImpl implements ICargoService {

	@Autowired
	private ICargoRepo repo;
	
	@Override
	public Cargo registrar(Cargo obj) {
		return repo.save(obj);
	}
	
	@Override
	public Cargo modificar(Cargo obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Cargo> listar(){
		return repo.findAll();
	}
	
	@Override
	public Cargo leerPorId(Integer id) {
		Optional<Cargo> op =  repo.findById(id);
		return op.isPresent() ? op.get() : new Cargo();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public Page<Cargo> listarPageable(Pageable pageable){
		return repo.findAll(pageable);
	}
}
