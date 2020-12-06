package my.condominium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import my.condominium.model.Directiva;
import my.condominium.repo.IDirectivaRepo;
import my.condominium.service.IDirectivaService;

@Service
public class DirectivaServiceImpl implements IDirectivaService {

	@Autowired
	private IDirectivaRepo repo;
	
	@Override
	public Directiva registrar(Directiva obj) {
		return repo.save(obj);
	}
	
	@Override
	public Directiva modificar(Directiva obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Directiva> listar(){
		return repo.findAll();
	}
	
	@Override
	public Directiva leerPorId(Integer id) {
		Optional<Directiva> op =  repo.findById(id);
		return op.isPresent() ? op.get() : new Directiva();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public Page<Directiva> listarPageable(Pageable pageable){
		return repo.findAll(pageable);
	}
}
