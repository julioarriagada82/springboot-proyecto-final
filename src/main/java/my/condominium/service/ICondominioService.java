package my.condominium.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import my.condominium.model.Condominio;

public interface ICondominioService extends ICRUD<Condominio> {

	Page<Condominio> listarPageable(Pageable pageable);
}
