package my.condominium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import my.condominium.model.Archivo;

public interface IArchivoRepo extends JpaRepository<Archivo, Integer> {
	
}
