package my.condominium.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import my.condominium.model.AreaComun;

public interface IAreaComunService extends ICRUD<AreaComun> {

	Page<AreaComun> listarPageable(Pageable pageable);
}
