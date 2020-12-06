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
@Table( name = "condominio")
public class Condominio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCondominio;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_condominio", nullable = false, foreignKey = @ForeignKey(name = "FK_condominio_tipo_condominio"))
	private TipoCondominio tipoCondominio;
	
	@ApiModelProperty(notes = "Nombre debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre debe tener mínimo 3 caracteres")
	@Column(name = "nombre_condominio", nullable = false, length = 50)
	private String nombreCondominio;
	
	@ApiModelProperty(notes = "Descripción debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Descripción debe tener mínimo 3 caracteres")
	@Column(name = "descripcion_condominio", nullable = false, length = 200)
	private String descripcionCondominio;

	@ApiModelProperty(notes = "Dirección debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Dirección debe tener mínimo 3 caracteres")
	@Column(name = "direccion_condominio", nullable = false, length = 200)
	private String direccionCondominio;
	
	@ApiModelProperty(notes = "Url debe tener minimo 10 caracteres")
	@Size(min = 10, message = "Url debe tener mínimo 10 caracteres")
	@Column(name = "url_condominio", nullable = false, length = 200)
	private String urlCondominio;
	
	@ApiModelProperty(notes = "Telefono debe tener 9 caracteres")
	@Size(min = 9, max = 9, message = "Telefono debe tener 9 caracteres")
	@Column(name = "telefono_condominio", nullable = false, length = 9)
	private String telefonoCondominio;

	public Integer getIdCondominio() {
		return idCondominio;
	}

	public void setIdCondominio(Integer idCondominio) {
		this.idCondominio = idCondominio;
	}

	public TipoCondominio getTipoCondominio() {
		return tipoCondominio;
	}

	public void setTipoCondominio(TipoCondominio tipoCondominio) {
		this.tipoCondominio = tipoCondominio;
	}

	public String getNombreCondominio() {
		return nombreCondominio;
	}

	public void setNombreCondominio(String nombreCondominio) {
		this.nombreCondominio = nombreCondominio;
	}
	
	public String getDescripcionCondominio() {
		return descripcionCondominio;
	}

	public void setDescripcionCondominio(String descripcionCondominio) {
		this.descripcionCondominio = descripcionCondominio;
	}

	public String getDireccionCondominio() {
		return direccionCondominio;
	}

	public void setDireccionCondominio(String direccionCondominio) {
		this.direccionCondominio = direccionCondominio;
	}

	public String getUrlCondominio() {
		return urlCondominio;
	}

	public void setUrlCondominio(String urlCondominio) {
		this.urlCondominio = urlCondominio;
	}

	public String getTelefonoCondominio() {
		return telefonoCondominio;
	}

	public void setTelefonoCondominio(String telefonoCondominio) {
		this.telefonoCondominio = telefonoCondominio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCondominio == null) ? 0 : idCondominio.hashCode());
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
		Condominio other = (Condominio) obj;
		if (idCondominio == null) {
			if (other.idCondominio != null)
				return false;
		} else if (!idCondominio.equals(other.idCondominio))
			return false;
		return true;
	}
}
