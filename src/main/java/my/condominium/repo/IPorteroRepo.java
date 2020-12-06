package my.condominium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import my.condominium.model.Portero;

public interface IPorteroRepo extends JpaRepository<Portero, Integer> {

}
