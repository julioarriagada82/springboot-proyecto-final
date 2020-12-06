package my.condominium.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table( name = "horario_turno")
public class HorarioTurno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHorarioTurno;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_periodo_horario", nullable = false, foreignKey = @ForeignKey(name = "FK_integrante_casa"))
	private PeriodoHorario periodoHorario;
	
	@ApiModelProperty(notes = "Nombre debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre debe tener mínimo 3 caracteres")
	@Column(name = "nombre_horario_turno", nullable = false, length = 50)
	private String nombreHorarioTurno;
	
	@Column(name = "cerrado_horario_turno", nullable = false)
	private Boolean cerradoHorarioTurno;
	
	@ApiModelProperty(notes = "Hora inicio debe tener minimo 5 caracteres")
	@Size(min = 5, max = 5, message = "Hora inicio debe tener 5 caracteres")
	@Column(name = "hora_inicio_horario_turno", nullable = false, length = 5)
	private String horaInicioHorarioTurno;
	
	@ApiModelProperty(notes = "Hora termino debe tener minimo 5 caracteres")
	@Size(min = 5, max = 5, message = "Hora termino debe tener mínimo 5 caracteres")
	@Column(name = "hora_termino_horario_turno", nullable = false, length = 5)
	private String horaTerminoHorarioTurno;

	public Integer getIdHorarioTurno() {
		return idHorarioTurno;
	}

	public void setIdHorarioTurno(Integer idHorarioTurno) {
		this.idHorarioTurno = idHorarioTurno;
	}

	public PeriodoHorario getPeriodoHorario() {
		return periodoHorario;
	}

	public void setPeriodoHorario(PeriodoHorario periodoHorario) {
		this.periodoHorario = periodoHorario;
	}

	public String getNombreHorarioTurno() {
		return nombreHorarioTurno;
	}

	public void setNombreHorarioTurno(String nombreHorarioTurno) {
		this.nombreHorarioTurno = nombreHorarioTurno;
	}

	public Boolean getCerradoHorarioTurno() {
		return cerradoHorarioTurno;
	}

	public void setCerradoHorarioTurno(Boolean cerradoHorarioTurno) {
		this.cerradoHorarioTurno = cerradoHorarioTurno;
	}

	public String getHoraInicioHorarioTurno() {
		return horaInicioHorarioTurno;
	}

	public void setHoraInicioHorarioTurno(String horaInicioHorarioTurno) {
		this.horaInicioHorarioTurno = horaInicioHorarioTurno;
	}

	public String getHoraTerminoHorarioTurno() {
		return horaTerminoHorarioTurno;
	}

	public void setHoraTerminoHorarioTurno(String horaTerminoHorarioTurno) {
		this.horaTerminoHorarioTurno = horaTerminoHorarioTurno;
	}
}
