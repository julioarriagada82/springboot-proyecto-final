package my.condominium.model;

import java.time.LocalDateTime;

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
@Table( name = "integrante")
public class Integrante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIntegrante;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_casa", nullable = false, foreignKey = @ForeignKey(name = "FK_integrante_casa"))
	private Casa casa;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_ocupacion", nullable = false, foreignKey = @ForeignKey(name = "FK_integrante_ocupacion"))
	private Ocupacion ocupacion;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_parentesco", nullable = false, foreignKey = @ForeignKey(name = "FK_integrante_parentesco"))
	private Parentesco parentesco;
	
	@ApiModelProperty(notes = "Rut debe tener minimo 9 caracteres")
	@Size(min = 9, message = "Rut debe tener mínimo 9 caracteres")
	@Column(name = "rut", nullable = false, length = 20)
	private String rut;
	
	@ApiModelProperty(notes = "Nombre debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre debe tener mínimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@ApiModelProperty(notes = "Paterno debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Paterno debe tener mínimo 3 caracteres")
	@Column(name = "paterno", nullable = false, length = 50)
	private String paterno;
	
	@ApiModelProperty(notes = "Materno debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Materno debe tener mínimo 3 caracteres")
	@Column(name = "materno", nullable = false, length = 50)
	private String materno;
	
	@ApiModelProperty(notes = "Email debe tener minimo 20 caracteres")
	@Size(min = 20,message = "Email debe tener mínimo 20 caracteres")
	@Column(name = "email", nullable = false, length = 200)
	private String email;
	
	@ApiModelProperty(notes = "Telefono debe tener minimo 9 caracteres")
	@Size(min = 9, max = 9, message = "Telefono debe tener 9 caracteres")
	@Column(name = "telefono", nullable = false, length = 9)
	private String telefono;
	
	@ApiModelProperty(notes = "Fecha nacimiento debe tener 12 caracteres")
	@Size(min = 12, max = 12, message = "Fecha nacimiento debe tener 12 caracteres")
	@Column(name = "fecha_nacimiento", nullable = false, length = 12)
	private LocalDateTime fecha_nacimiento;

	public Integer getIdIntegrante() {
		return idIntegrante;
	}

	public void setIdIntegrante(Integer idIntegrante) {
		this.idIntegrante = idIntegrante;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public Ocupacion getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(Ocupacion ocupacion) {
		this.ocupacion = ocupacion;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDateTime getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDateTime fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
}
