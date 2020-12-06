package my.condominium.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import my.condominium.model.Integrante;

public interface IIntegranteService extends ICRUD<Integrante> {

	Page<Integrante> listarPageable(Pageable pageable);
}
