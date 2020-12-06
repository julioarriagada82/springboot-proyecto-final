package my.condominium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import my.condominium.model.Integrante;
import my.condominium.repo.IIntegranteRepo;
import my.condominium.service.IIntegranteService;

@Service
public class IntegranteServiceImpl implements IIntegranteService {

	@Autowired
	private IIntegranteRepo repo;
	
	@Override
	public Integrante registrar(Integrante obj) {
		return repo.save(obj);
	}
	
	@Override
	public Integrante modificar(Integrante obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Integrante> listar(){
		return repo.findAll();
	}
	
	@Override
	public Integrante leerPorId(Integer id) {
		Optional<Integrante> op =  repo.findById(id);
		return op.isPresent() ? op.get() : new Integrante();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public Page<Integrante> listarPageable(Pageable pageable){
		return repo.findAll(pageable);
	}
}
