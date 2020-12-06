package my.condominium.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.condominium.model.ConsultaAreaComun;
import my.condominium.repo.IConsultaAreaComunRepo;
import my.condominium.service.IConsultaAreaComunService;

@Service
public class ConsultaAreaComunServiceImpl implements IConsultaAreaComunService {

	@Autowired
	private IConsultaAreaComunRepo repo;
	
	@Override
	public List<ConsultaAreaComun> listarAreasComunesPorConsulta(Integer idconsulta) {
		return repo.listarAreasComunesPorConsulta(idconsulta);
	}
}
