package my.condominium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import my.condominium.model.AreaComun;
import my.condominium.repo.IAreaComunRepo;
import my.condominium.service.IAreaComunService;

@Service
public class AreaComunServiceImpl implements IAreaComunService {

	@Autowired
	private IAreaComunRepo repo;
	
	@Override
	public AreaComun registrar(AreaComun obj) {
		return repo.save(obj);
	}
	
	@Override
	public AreaComun modificar(AreaComun obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<AreaComun> listar(){
		return repo.findAll();
	}
	
	@Override
	public AreaComun leerPorId(Integer id) {
		Optional<AreaComun> op =  repo.findById(id);
		return op.isPresent() ? op.get() : new AreaComun();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public Page<AreaComun> listarPageable(Pageable pageable){
		return repo.findAll(pageable);
	}
}
