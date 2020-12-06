package my.condominium.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsulta;
	
	@ManyToOne
	@JoinColumn(name = "id_integrante", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_integrante"))
	private Integrante integrante;
	
	@ManyToOne
	@JoinColumn(name = "id_area_comun", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_area_comun"))
	private AreaComun areaComun;
	
	private LocalDateTime fecha;
	
	@OneToMany(mappedBy = "consulta", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<DetalleConsulta> detalleConsulta;

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Integrante getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}

	public AreaComun getAreaComun() {
		return areaComun;
	}

	public void setAreaComun(AreaComun areaComun) {
		this.areaComun = areaComun;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idConsulta == null) ? 0 : idConsulta.hashCode());
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
		Consulta other = (Consulta) obj;
		if (idConsulta == null) {
			if (other.idConsulta != null)
				return false;
		} else if (!idConsulta.equals(other.idConsulta))
			return false;
		return true;
	}
}
