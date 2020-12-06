package my.condominium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import my.condominium.model.Casa;
import my.condominium.repo.ICasaRepo;
import my.condominium.service.ICasaService;

@Service
public class CasaServiceImpl implements ICasaService {

	@Autowired
	private ICasaRepo repo;
	
	@Override
	public Casa registrar(Casa obj) {
		return repo.save(obj);
	}
	
	@Override
	public Casa modificar(Casa obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Casa> listar(){
		return repo.findAll();
	}
	
	@Override
	public Casa leerPorId(Integer id) {
		Optional<Casa> op =  repo.findById(id);
		return op.isPresent() ? op.get() : new Casa();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public Page<Casa> listarPageable(Pageable pageable){
		return repo.findAll(pageable);
	}
}
