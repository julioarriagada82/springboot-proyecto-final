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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalle_consulta")
public class DetalleConsulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalle;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_consulta", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_detalle"))
	private Consulta consulta;
	
	
	@Column(name = "material", nullable = false, length = 70)
	private String material;


	public int getIdDetalle() {
		return idDetalle;
	}


	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}


	public Consulta getConsulta() {
		return consulta;
	}


	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}
	
	
}
