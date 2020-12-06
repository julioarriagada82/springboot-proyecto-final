package my.condominium.dto;

import java.util.List;

import my.condominium.model.AreaComun;
import my.condominium.model.Consulta;

public class ConsultaListaAreaComunDTO {

	private Consulta consulta;
	private List<AreaComun> lstAreaComun;
	
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public List<AreaComun> getLstAreaComun() {
		return lstAreaComun;
	}
	public void setLstAreaComun(List<AreaComun> lstAreaComun) {
		this.lstAreaComun = lstAreaComun;
	}
	
	
}
