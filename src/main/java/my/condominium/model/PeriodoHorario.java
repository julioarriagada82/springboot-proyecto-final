package my.condominium.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table( name = "periodo_horario")
public class PeriodoHorario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPeriodoHorario;
	
	@ApiModelProperty(notes = "Nombre debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre debe tener mínimo 3 caracteres")
	@Column(name = "nombre_periodo_horario", nullable = false, length = 50)
	private String nombrePeriodoHorario;

	public Integer getIdPeriodoHorario() {
		return idPeriodoHorario;
	}

	public void setIdPeriodoHorario(Integer idPeriodoHorario) {
		this.idPeriodoHorario = idPeriodoHorario;
	}

	public String getNombrePeriodoHorario() {
		return nombrePeriodoHorario;
	}

	public void setNombrePeriodoHorario(String nombrePeriodoHorario) {
		this.nombrePeriodoHorario = nombrePeriodoHorario;
	}
}
