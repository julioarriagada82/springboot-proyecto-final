package my.condominium.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import my.condominium.model.Portero;

public interface IPorteroService extends ICRUD<Portero> {

	Page<Portero> listarPageable(Pageable pageable);
}
