package my.condominium.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table( name = "portero_horario")
@IdClass(PorteroTurnoPK.class)
public class PorteroTurno {
	
	@Id
	private Portero portero;
	
	@Id
	private HorarioTurno horarioTurno;

	public Portero getPortero() {
		return portero;
	}

	public void setPortero(Portero portero) {
		this.portero = portero;
	}

	public HorarioTurno getHorarioTurno() {
		return horarioTurno;
	}

	public void setHorarioTurno(HorarioTurno horarioTurno) {
		this.horarioTurno = horarioTurno;
	}
}
