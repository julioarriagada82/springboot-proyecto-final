package my.condominium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import my.condominium.model.TipoCondominio;
import my.condominium.repo.ITipoCondominioRepo;
import my.condominium.service.ITipoCondominioService;

@Service
public class TipoCondominioServiceImpl implements ITipoCondominioService {

	@Autowired
	private ITipoCondominioRepo repo;
	
	@Override
	public TipoCondominio registrar(TipoCondominio obj) {
		return repo.save(obj);
	}
	
	@Override
	public TipoCondominio modificar(TipoCondominio obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<TipoCondominio> listar(){
		return repo.findAll();
	}
	
	@Override
	public TipoCondominio leerPorId(Integer id) {
		Optional<TipoCondominio> op =  repo.findById(id);
		return op.isPresent() ? op.get() : new TipoCondominio();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public Page<TipoCondominio> listarPageable(Pageable pageable){
		return repo.findAll(pageable);
	}
}
