package my.condominium.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CondominioDirectivaPK implements Serializable {

	@ManyToOne
	@JoinColumn(name = "id_condominio", nullable = false)
	private Condominio condominio;
	
	@ManyToOne
	@JoinColumn(name = "id_directiva", nullable = false)
	private Directiva directiva;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((condominio == null) ? 0 : condominio.hashCode());
		result = prime * result + ((directiva == null) ? 0 : directiva.hashCode());
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
		CondominioDirectivaPK other = (CondominioDirectivaPK) obj;
		if (condominio == null) {
			if (other.condominio != null)
				return false;
		} else if (!condominio.equals(other.condominio))
			return false;
		if (directiva == null) {
			if (other.directiva != null)
				return false;
		} else if (!directiva.equals(other.directiva))
			return false;
		return true;
	}
}
