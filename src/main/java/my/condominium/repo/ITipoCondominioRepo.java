package my.condominium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import my.condominium.model.TipoCondominio;

public interface ITipoCondominioRepo extends JpaRepository<TipoCondominio, Integer> {

}
