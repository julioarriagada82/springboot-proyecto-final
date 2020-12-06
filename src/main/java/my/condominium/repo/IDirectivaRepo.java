package my.condominium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import my.condominium.model.Directiva;

public interface IDirectivaRepo extends JpaRepository<Directiva, Integer> {

}
