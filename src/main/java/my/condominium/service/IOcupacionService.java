package my.condominium.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import my.condominium.model.Ocupacion;

public interface IOcupacionService extends ICRUD<Ocupacion> {

	Page<Ocupacion> listarPageable(Pageable pageable);
}
