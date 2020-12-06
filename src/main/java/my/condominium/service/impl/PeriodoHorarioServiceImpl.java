package my.condominium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import my.condominium.model.PeriodoHorario;
import my.condominium.repo.IPeriodoHorarioRepo;
import my.condominium.service.IPeriodoHorarioService;

@Service
public class PeriodoHorarioServiceImpl implements IPeriodoHorarioService {

	@Autowired
	private IPeriodoHorarioRepo repo;
	
	@Override
	public PeriodoHorario registrar(PeriodoHorario obj) {
		return repo.save(obj);
	}
	
	@Override
	public PeriodoHorario modificar(PeriodoHorario obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<PeriodoHorario> listar(){
		return repo.findAll();
	}
	
	@Override
	public PeriodoHorario leerPorId(Integer id) {
		Optional<PeriodoHorario> op =  repo.findById(id);
		return op.isPresent() ? op.get() : new PeriodoHorario();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	@Override
	public Page<PeriodoHorario> listarPageable(Pageable pageable){
		return repo.findAll(pageable);
	}
}
