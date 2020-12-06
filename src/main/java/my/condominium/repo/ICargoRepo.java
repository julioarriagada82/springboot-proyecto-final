package my.condominium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import my.condominium.model.Cargo;

public interface ICargoRepo extends JpaRepository<Cargo, Integer> {

}
