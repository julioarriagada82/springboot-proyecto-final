package my.condominium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import my.condominium.model.Condominio;
import my.condominium.repo.ICondominioRepo;
import my.condominium.service.ICondominioService;

@Service
public class CondominioServiceImpl implements ICondominioService {

	@Autowired
	private ICondominioRepo repo;
	
	@Override
	public Condominio registrar(Condominio obj) {
		return repo.save(obj);
	}
	
	@Override
	public Condominio modificar(Condominio obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Condominio> listar(){
		return repo.findAll();
	}
	
	@Override
	public Condominio leerPorId(Integer id) {
		Optional<Condominio> op =  repo.findById(id);
		return op.isPresent() ? op.get() : new Condominio();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public Page<Condominio> listarPageable(Pageable pageable){
		return repo.findAll(pageable);
	}
	
}
