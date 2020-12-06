package my.condominium.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table( name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReserva;
	
	@ApiModelProperty(notes = "Nombre debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre debe tener mínimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_area_comun", nullable = false, foreignKey = @ForeignKey(name = "FK_reserva_area_comun"))
	private AreaComun areaComun;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_casa", nullable = false, foreignKey = @ForeignKey(name = "FK_reserva_casa"))
	private Casa casa;
	
	private LocalDateTime fecha;
	
	
	@OneToMany(mappedBy = "consulta", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<DetalleConsulta> detalleConsulta;


	public Integer getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public AreaComun getAreaComun() {
		return areaComun;
	}


	public void setAreaComun(AreaComun areaComun) {
		this.areaComun = areaComun;
	}


	public Casa getCasa() {
		return casa;
	}


	public void setCasa(Casa casa) {
		this.casa = casa;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}


	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}


	public List<DetalleConsulta> getDetalleConsulta() {
		return detalleConsulta;
	}


	public void setDetalleConsulta(List<DetalleConsulta> detalleConsulta) {
		this.detalleConsulta = detalleConsulta;
	}
}
