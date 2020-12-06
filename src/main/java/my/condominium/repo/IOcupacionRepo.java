package my.condominium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import my.condominium.model.Ocupacion;

public interface IOcupacionRepo extends JpaRepository<Ocupacion, Integer> {

}
