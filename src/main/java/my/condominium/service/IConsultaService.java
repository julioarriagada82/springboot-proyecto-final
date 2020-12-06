package my.condominium.service;

import java.util.List;

import my.condominium.dto.ConsultaListaAreaComunDTO;
import my.condominium.dto.ConsultaResumenDTO;
import my.condominium.dto.FiltroConsultaDTO;
import my.condominium.model.Consulta;


public interface IConsultaService extends ICRUD<Consulta> {
	
Consulta registrarTransaccional(ConsultaListaAreaComunDTO dto);
	
	List<Consulta> buscar(FiltroConsultaDTO filtro);
	
	List<Consulta> buscarFecha(FiltroConsultaDTO filtro);
	
	List<ConsultaResumenDTO> listarResumen();
	
	byte[] generarReporte();
	
}
