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
@Table( name = "portero")
public class Portero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPortero;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_condominio", nullable = false, foreignKey = @ForeignKey(name = "FK_portero_condominio"))
	private Condominio condominio;
	
	@ApiModelProperty(notes = "Rut debe tener minimo 9 caracteres")
	@Size(min = 9, message = "Rut debe tener mínimo 9 caracteres")
	@Column(name = "rut_portero", nullable = false, length = 20)
	private String rutPortero;
	
	@ApiModelProperty(notes = "Nombre debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre debe tener mínimo 3 caracteres")
	@Column(name = "nombre_portero", nullable = false, length = 50)
	private String nombrePortero;
	
	@ApiModelProperty(notes = "Paterno debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Paterno debe tener mínimo 3 caracteres")
	@Column(name = "paterno_portero", nullable = false, length = 50)
	private String paternoPortero;
	
	@ApiModelProperty(notes = "Materno debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Materno debe tener mínimo 3 caracteres")
	@Column(name = "materno_portero", nullable = false, length = 50)
	private String maternoPortero;
	
	@ApiModelProperty(notes = "Email debe tener minimo 3 caracteres")
	@Size(min = 20,message = "Email debe tener mínimo 20 caracteres")
	@Column(name = "email_portero", nullable = false, length = 200)
	private String emailPortero;

	public Integer getIdPortero() {
		return idPortero;
	}

	public void setIdPortero(Integer idPortero) {
		this.idPortero = idPortero;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public String getRutPortero() {
		return rutPortero;
	}

	public void setRutPortero(String rutPortero) {
		this.rutPortero = rutPortero;
	}

	public String getNombrePortero() {
		return nombrePortero;
	}

	public void setNombrePortero(String nombrePortero) {
		this.nombrePortero = nombrePortero;
	}

	public String getPaternoPortero() {
		return paternoPortero;
	}

	public void setPaternoPortero(String paternoPortero) {
		this.paternoPortero = paternoPortero;
	}

	public String getMaternoPortero() {
		return maternoPortero;
	}

	public void setMaternoPortero(String maternoPortero) {
		this.maternoPortero = maternoPortero;
	}

	public String getEmailPortero() {
		return emailPortero;
	}

	public void setEmailPortero(String emailPortero) {
		this.emailPortero = emailPortero;
	}
}
