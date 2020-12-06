package my.condominium.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import my.condominium.model.PorteroTurno;

public interface IPorteroTurnoService extends ICRUD<PorteroTurno> {

	Page<PorteroTurno> listarPageable(Pageable pageable);
}
