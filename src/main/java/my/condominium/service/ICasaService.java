package my.condominium.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import my.condominium.model.Casa;

public interface ICasaService extends ICRUD<Casa> {

	Page<Casa> listarPageable(Pageable pageable);
}
