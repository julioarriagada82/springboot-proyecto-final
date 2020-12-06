package my.condominium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import my.condominium.model.AreaComun;

public interface IAreaComunRepo extends JpaRepository<AreaComun, Integer> {

}
