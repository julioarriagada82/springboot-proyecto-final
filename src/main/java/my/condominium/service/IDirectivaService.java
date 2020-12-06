package my.condominium.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import my.condominium.model.Directiva;

public interface IDirectivaService extends ICRUD<Directiva> {

	Page<Directiva> listarPageable(Pageable pageable);
}
