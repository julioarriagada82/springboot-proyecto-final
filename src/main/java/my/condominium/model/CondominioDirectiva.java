package my.condominium.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table( name = "condominio_directiva")
@IdClass(CondominioDirectivaPK.class)
public class CondominioDirectiva {

	@Id
	private Condominio condominio;
	
	@Id
	private Directiva directiva;

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public Directiva getDirectiva() {
		return directiva;
	}

	public void setDirectiva(Directiva directiva) {
		this.directiva = directiva;
	}
}
