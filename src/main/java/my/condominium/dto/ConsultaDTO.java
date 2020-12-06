package my.condominium.dto;

import org.springframework.hateoas.ResourceSupport;

import my.condominium.model.AreaComun;
import my.condominium.model.Integrante;

public class ConsultaDTO extends ResourceSupport {

	private Integer idConsulta;
	private AreaComun areaComun;
	private Integrante integrante;
	public Integer getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}
	public AreaComun getAreaComun() {
		return areaComun;
	}
	public void setAreaComun(AreaComun areaComun) {
		this.areaComun = areaComun;
	}
	public Integrante getIntegrante() {
		return integrante;
	}
	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}
}
