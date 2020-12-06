package my.condominium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import my.condominium.model.Usuario;


public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {

	//select * from usuario where username = ?
	Usuario findOneByUsername(String username);
}