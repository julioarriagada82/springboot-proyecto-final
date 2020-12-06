package my.condominium.service;

import my.condominium.model.Archivo;

public interface IArchivoService {
	
	int guardar(Archivo archivo);
	byte[] leerArchivo(Integer idArchivo);

}
