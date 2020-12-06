package my.condominium.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import my.condominium.model.CondominioDirectiva;

public interface ICondominioDirectivaService extends ICRUD<CondominioDirectiva> {

	Page<CondominioDirectiva> listarPageable(Pageable pageable);
}
