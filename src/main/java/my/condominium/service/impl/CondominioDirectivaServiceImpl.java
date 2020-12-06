package my.condominium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import my.condominium.model.CondominioDirectiva;
import my.condominium.repo.ICondominioDirectivaRepo;
import my.condominium.service.ICondominioDirectivaService;

@Service
public class CondominioDirectivaServiceImpl implements ICondominioDirectivaService {

	@Autowired
	private ICondominioDirectivaRepo repo;
	
	@Override
	public CondominioDirectiva registrar(CondominioDirectiva obj) {
		return repo.save(obj);
	}
	
	@Override
	public CondominioDirectiva modificar(CondominioDirectiva obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<CondominioDirectiva> listar(){
		return repo.findAll();
	}
	
	@Override
	public CondominioDirectiva leerPorId(Integer id) {
		Optional<CondominioDirectiva> op =  repo.findById(id);
		return op.isPresent() ? op.get() : new CondominioDirectiva();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public Page<CondominioDirectiva> listarPageable(Pageable pageable){
		return repo.findAll(pageable);
	}
}
