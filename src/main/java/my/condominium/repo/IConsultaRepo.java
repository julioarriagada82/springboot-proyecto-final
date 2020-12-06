package my.condominium.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import my.condominium.model.Consulta;


public interface IConsultaRepo extends JpaRepository<Consulta, Integer>{

	@Query("from Consulta c where c.integrante.rut =:dni or LOWER(c.integrante.nombre) like %:nombreCompleto% or LOWER(c.integrante.paterno) like %:nombreCompleto%")
	List<Consulta> buscar(@Param("dni")String dni,@Param("nombreCompleto") String nombreCompleto);

	// >= <
	@Query("from Consulta c where c.fecha between :fechaConsulta and :fechaSgte")
	List<Consulta> buscarFecha(@Param("fechaConsulta") LocalDateTime fechaConsulta, @Param("fechaSgte") LocalDateTime fechaSgte);
	
	@Query(value = "select * from fn_listarResumen()", nativeQuery = true)
	List<Object[]> listarResumen();
}
