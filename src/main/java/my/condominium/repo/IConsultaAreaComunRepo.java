package my.condominium.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import my.condominium.model.ConsultaAreaComun;

public interface IConsultaAreaComunRepo extends JpaRepository<ConsultaAreaComun, Integer> {

	//@Transactional
	@Modifying
	@Query(value = "INSERT INTO consulta_area_comun(id_consulta, id_area_comun) VALUES (:idConsulta, :idAreaComun)", nativeQuery = true)
	Integer registrar(@Param("idConsulta") Integer idConsulta, @Param("idAreaComun") Integer idAreaComun);
	
	@Query("from ConsultaAreaComun cac where cac.consulta.idConsulta = :idConsulta")
	List<ConsultaAreaComun> listarAreasComunesPorConsulta(@Param("idConsulta") Integer idconsulta);
}
