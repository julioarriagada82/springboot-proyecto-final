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

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table( name = "lista_negra")
public class ListaNegra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idListaNegra;
	
	@ManyToOne
	@JoinColumn(name = "id_casa", nullable = false, foreignKey = @ForeignKey(name = "FK_lista_negra_casa"))
	private Casa casa;
	
	@ApiModelProperty(notes = "Rut debe tener minimo 9 caracteres")
	@Size(min = 9, message = "Rut debe tener mínimo 9 caracteres")
	@Column(name = "rut_lista_negra", nullable = false, length = 20)
	private String rutListaNegra;
	
	@ApiModelProperty(notes = "Nombre debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre debe tener mínimo 3 caracteres")
	@Column(name = "nombre_lista_negra", nullable = false, length = 50)
	private String nombreListaNegra;
	
	@ApiModelProperty(notes = "Paterno debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Paterno debe tener mínimo 3 caracteres")
	@Column(name = "paterno_lista_negra", nullable = false, length = 50)
	private String paternoListaNegra;
	
	@ApiModelProperty(notes = "Materno debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Materno debe tener mínimo 3 caracteres")
	@Column(name = "materno_lista_negra", nullable = false, length = 50)
	private String maternoListaNegra;
	
	@ApiModelProperty(notes = "Email debe tener minimo 20 caracteres")
	@Size(min = 20,message = "Email debe tener mínimo 20 caracteres")
	@Column(name = "motivo_lista_negra", nullable = false, length = 200)
	private String motivoListaNegra;

	public Integer getIdListaNegra() {
		return idListaNegra;
	}

	public void setIdListaNegra(Integer idListaNegra) {
		this.idListaNegra = idListaNegra;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public String getRutListaNegra() {
		return rutListaNegra;
	}

	public void setRutListaNegra(String rutListaNegra) {
		this.rutListaNegra = rutListaNegra;
	}

	public String getNombreListaNegra() {
		return nombreListaNegra;
	}

	public void setNombreListaNegra(String nombreListaNegra) {
		this.nombreListaNegra = nombreListaNegra;
	}

	public String getPaternoListaNegra() {
		return paternoListaNegra;
	}

	public void setPaternoListaNegra(String paternoListaNegra) {
		this.paternoListaNegra = paternoListaNegra;
	}

	public String getMaternoListaNegra() {
		return maternoListaNegra;
	}

	public void setMaternoListaNegra(String maternoListaNegra) {
		this.maternoListaNegra = maternoListaNegra;
	}

	public String getMotivoListaNegra() {
		return motivoListaNegra;
	}

	public void setMotivoListaNegra(String motivoListaNegra) {
		this.motivoListaNegra = motivoListaNegra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idListaNegra == null) ? 0 : idListaNegra.hashCode());
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
		ListaNegra other = (ListaNegra) obj;
		if (idListaNegra == null) {
			if (other.idListaNegra != null)
				return false;
		} else if (!idListaNegra.equals(other.idListaNegra))
			return false;
		return true;
	}
	
	
}
