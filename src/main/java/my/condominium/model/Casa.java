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
@Table( name = "casa")
public class Casa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCasa;
	
	@ManyToOne
	@JoinColumn(name = "id_condominio", nullable = false, foreignKey = @ForeignKey(name = "FK_condominio_casa"))
	private Condominio condominio;
	
	@ApiModelProperty(notes = "Nombre debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre debe tener mínimo 3 caracteres")
	@Column(name = "nombre_casa", nullable = false, length = 50)
	private String nombreCasa;
	
	@ApiModelProperty(notes = "Direccion debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Direccion debe tener mínimo 3 caracteres")
	@Column(name = "direccion_casa", nullable = false, length = 50)
	private String direccionCasa;
	
	@ApiModelProperty(notes = "Telefono debe tener 9 caracteres")
	@Size(min = 9, max = 9, message = "Telefono debe tener 9 caracteres")
	@Column(name = "telefono_casa", nullable = false, length = 9)
	private String telefonoCasa;

	public Integer getIdCasa() {
		return idCasa;
	}

	public void setIdCasa(Integer idCasa) {
		this.idCasa = idCasa;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public String getNombreCasa() {
		return nombreCasa;
	}

	public void setNombreCasa(String nombreCasa) {
		this.nombreCasa = nombreCasa;
	}

	public String getDireccionCasa() {
		return direccionCasa;
	}

	public void setDireccionCasa(String direccionCasa) {
		this.direccionCasa = direccionCasa;
	}

	public String getTelefonoCasa() {
		return telefonoCasa;
	}

	public void setTelefonoCasa(String telefonoCasa) {
		this.telefonoCasa = telefonoCasa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCasa == null) ? 0 : idCasa.hashCode());
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
		Casa other = (Casa) obj;
		if (idCasa == null) {
			if (other.idCasa != null)
				return false;
		} else if (!idCasa.equals(other.idCasa))
			return false;
		return true;
	}
	
	
}
