package my.condominium.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "consulta_area_comun")
@IdClass(ConsultaAreaComunPK.class)
public class ConsultaAreaComun {

	@Id
	private AreaComun areaComun;
	
	@Id
	private Consulta consulta;

	public AreaComun getAreaComun() {
		return areaComun;
	}

	public void setAreaComun(AreaComun areaComun) {
		this.areaComun = areaComun;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	
	
}
