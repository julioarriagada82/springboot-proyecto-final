package my.condominium.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import my.condominium.model.Cargo;

public interface ICargoService extends ICRUD<Cargo> {

	Page<Cargo> listarPageable(Pageable pageable);
}
