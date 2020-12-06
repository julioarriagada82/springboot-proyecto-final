package my.condominium.repo;

import org.springframework.data.jpa.repository.JpaRepository;
 
import my.condominium.model.ListaNegra;

public interface IListaNegraRepo extends JpaRepository<ListaNegra, Integer> {

}
