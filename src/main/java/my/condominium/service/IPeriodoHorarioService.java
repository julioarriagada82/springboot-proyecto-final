package my.condominium.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import my.condominium.model.PeriodoHorario;

public interface IPeriodoHorarioService extends ICRUD<PeriodoHorario> {

	Page<PeriodoHorario> listarPageable(Pageable pageable);
}
