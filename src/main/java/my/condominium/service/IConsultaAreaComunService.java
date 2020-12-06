package my.condominium.service;

import java.util.List;

import my.condominium.model.ConsultaAreaComun;

public interface IConsultaAreaComunService {
	
	List<ConsultaAreaComun> listarAreasComunesPorConsulta(Integer idConsulta);

}
