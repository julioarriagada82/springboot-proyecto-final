package my.condominium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import my.condominium.model.Casa;

public interface ICasaRepo extends JpaRepository<Casa, Integer> {

}
