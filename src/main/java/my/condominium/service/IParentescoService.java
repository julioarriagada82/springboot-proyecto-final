package my.condominium.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import my.condominium.model.Parentesco;

public interface IParentescoService extends ICRUD<Parentesco> {

	Page<Parentesco> listarPageable(Pageable pageable);
}
