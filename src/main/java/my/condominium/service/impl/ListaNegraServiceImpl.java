package my.condominium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import my.condominium.model.ListaNegra;
import my.condominium.repo.IListaNegraRepo;
import my.condominium.service.IListaNegraService;

@Service
public class ListaNegraServiceImpl implements IListaNegraService {

	@Autowired
	private IListaNegraRepo repo;
	
	@Override
	public ListaNegra registrar(ListaNegra obj) {
		return repo.save(obj);
	}
	
	@Override
	public ListaNegra modificar(ListaNegra obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<ListaNegra> listar(){
		return repo.findAll();
	}
	
	@Override
	public ListaNegra leerPorId(Integer id) {
		Optional<ListaNegra> op =  repo.findById(id);
		return op.isPresent() ? op.get() : new ListaNegra();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public Page<ListaNegra> listarPageable(Pageable pageable){
		return repo.findAll(pageable);
	}
}
