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
@Table( name = "directiva")
public class Directiva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDirectiva;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_cargo", nullable = false, foreignKey = @ForeignKey(name = "FK_directiva_cargo"))
	private Cargo cargo;
	
	@ApiModelProperty(notes = "Rut debe tener minimo 9 caracteres")
	@Size(min = 9, message = "Rut debe tener mínimo 9 caracteres")
	@Column(name = "rut_directiva", nullable = false, length = 20)
	private String rutDirectiva;
	
	@ApiModelProperty(notes = "Nombre debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre debe tener mínimo 3 caracteres")
	@Column(name = "nombre_directiva", nullable = false, length = 50)
	private String nombreDirectiva;
	
	@ApiModelProperty(notes = "Paterno debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Paterno debe tener mínimo 3 caracteres")
	@Column(name = "paterno_directiva", nullable = false, length = 50)
	private String paternoDirectiva;
	
	@ApiModelProperty(notes = "Materno debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Materno debe tener mínimo 3 caracteres")
	@Column(name = "materno_directiva", nullable = false, length = 50)
	private String maternoDirectiva;
	
	@ApiModelProperty(notes = "Email debe tener minimo 20 caracteres")
	@Size(min = 20,message = "Email debe tener mínimo 20 caracteres")
	@Column(name = "email_directiva", nullable = false, length = 200)
	private String emailDirectiva;

	public Integer getIdDirectiva() {
		return idDirectiva;
	}

	public void setIdDirectiva(Integer idDirectiva) {
		this.idDirectiva = idDirectiva;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getRutDirectiva() {
		return rutDirectiva;
	}

	public void setRutDirectiva(String rutDirectiva) {
		this.rutDirectiva = rutDirectiva;
	}

	public String getNombreDirectiva() {
		return nombreDirectiva;
	}

	public void setNombreDirectiva(String nombreDirectiva) {
		this.nombreDirectiva = nombreDirectiva;
	}

	public String getPaternoDirectiva() {
		return paternoDirectiva;
	}

	public void setPaternoDirectiva(String paternoDirectiva) {
		this.paternoDirectiva = paternoDirectiva;
	}

	public String getMaternoDirectiva() {
		return maternoDirectiva;
	}

	public void setMaternoDirectiva(String maternoDirectiva) {
		this.maternoDirectiva = maternoDirectiva;
	}

	public String getEmailDirectiva() {
		return emailDirectiva;
	}

	public void setEmailDirectiva(String emailDirectiva) {
		this.emailDirectiva = emailDirectiva;
	}
}
