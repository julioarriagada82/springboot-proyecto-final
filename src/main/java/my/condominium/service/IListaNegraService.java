package my.condominium.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import my.condominium.model.ListaNegra;

public interface IListaNegraService extends ICRUD<ListaNegra> {

	Page<ListaNegra> listarPageable(Pageable pageable);
}
