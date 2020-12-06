package my.condominium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import my.condominium.model.Parentesco;
import my.condominium.repo.IParentescoRepo;
import my.condominium.service.IParentescoService;

@Service
public class ParentescoServiceImpl implements IParentescoService {

	@Autowired
	private IParentescoRepo repo;
	
	@Override
	public Parentesco registrar(Parentesco obj) {
		return repo.save(obj);
	}
	
	@Override
	public Parentesco modificar(Parentesco obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Parentesco> listar(){
		return repo.findAll();
	}
	
	@Override
	public Parentesco leerPorId(Integer id) {
		Optional<Parentesco> op =  repo.findById(id);
		return op.isPresent() ? op.get() : new Parentesco();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public Page<Parentesco> listarPageable(Pageable pageable){
		return repo.findAll(pageable);
	}
}
