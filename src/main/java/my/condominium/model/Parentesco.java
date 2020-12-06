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
@Table( name = "parentesco")
public class Parentesco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idParentesco;
	
	@ApiModelProperty(notes = "Nombre debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre debe tener mínimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	public Integer getIdParentesco() {
		return idParentesco;
	}

	public void setIdParentesco(Integer idParentesco) {
		this.idParentesco = idParentesco;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
