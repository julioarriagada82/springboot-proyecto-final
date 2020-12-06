package my.condominium.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import my.condominium.model.HorarioTurno;

public interface IHorarioTurnoService extends ICRUD<HorarioTurno> {

	Page<HorarioTurno> listarPageable(Pageable pageable);
}
