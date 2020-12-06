package my.condominium.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ConsultaAreaComunPK implements Serializable {

	@ManyToOne
	@JoinColumn(name = "id_area_comun", nullable = false)
	private AreaComun areaComun;
	
	@ManyToOne
	@JoinColumn(name = "id_consulta", nullable = false)
	private Consulta consulta;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consulta == null) ? 0 : consulta.hashCode());
		result = prime * result + ((areaComun == null) ? 0 : areaComun.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaAreaComunPK other = (ConsultaAreaComunPK) obj;
		if (consulta == null) {
			if (other.consulta != null)
				return false;
		} else if (!consulta.equals(other.consulta))
			return false;
		if (areaComun == null) {
			if (other.areaComun != null)
				return false;
		} else if (!areaComun.equals(other.areaComun))
			return false;
		return true;
	}
}
