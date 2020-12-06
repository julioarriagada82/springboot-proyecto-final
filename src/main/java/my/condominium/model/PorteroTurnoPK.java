package my.condominium.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PorteroTurnoPK implements Serializable {
	
	@ManyToOne
	@JoinColumn(name = "id_portero", nullable = false)
	private Portero portero;
	
	@ManyToOne
	@JoinColumn(name = "id_horario_turno", nullable = false)
	private HorarioTurno horarioTurno;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((horarioTurno == null) ? 0 : horarioTurno.hashCode());
		result = prime * result + ((portero == null) ? 0 : portero.hashCode());
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
		PorteroTurnoPK other = (PorteroTurnoPK) obj;
		if (horarioTurno == null) {
			if (other.horarioTurno != null)
				return false;
		} else if (!horarioTurno.equals(other.horarioTurno))
			return false;
		if (portero == null) {
			if (other.portero != null)
				return false;
		} else if (!portero.equals(other.portero))
			return false;
		return true;
	}
	
	

}
