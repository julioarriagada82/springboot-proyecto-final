package my.condominium.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import my.condominium.model.TipoCondominio;

public interface ITipoCondominioService extends ICRUD<TipoCondominio> {

	Page<TipoCondominio> listarPageable(Pageable pageable);
}
