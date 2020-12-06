package my.condominium.service;

import java.util.List;

import my.condominium.model.Menu;


public interface IMenuService extends ICRUD<Menu> {
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
