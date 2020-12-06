package my.condominium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import my.condominium.model.Condominio;

public interface ICondominioRepo extends JpaRepository<Condominio, Integer> {

}
