package my.condominium.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table( name = "area_comun")
public class AreaComun {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAreaComun;
	
	@Size(min = 3, message = "Nombre debe tener mínimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Size(min = 3, message = "Descripción debe tener mínimo 3 caracteres")
	@Column(name = "descripcion", nullable = false, length = 500)
	private String descripcion;

	public Integer getIdAreaComun() {
		return idAreaComun;
	}

	public void setIdAreaComun(Integer idAreaComun) {
		this.idAreaComun = idAreaComun;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
