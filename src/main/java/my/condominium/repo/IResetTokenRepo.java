package my.condominium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import my.condominium.model.ResetToken;


public interface IResetTokenRepo extends JpaRepository<ResetToken, Integer> {
	
	//from ResetToken where token = :?
	ResetToken findByToken(String token);

}
