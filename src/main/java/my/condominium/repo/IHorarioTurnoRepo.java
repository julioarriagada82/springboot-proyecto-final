package my.condominium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import my.condominium.model.HorarioTurno;

public interface IHorarioTurnoRepo extends JpaRepository<HorarioTurno, Integer> {

}
