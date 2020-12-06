package my.condominium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import my.condominium.model.Integrante;

public interface IIntegranteRepo extends JpaRepository<Integrante, Integer> {

}
