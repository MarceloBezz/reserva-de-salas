package br.com.alura.reserva.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.reserva.model.Reserva.Reserva;
import br.com.alura.reserva.model.Sala.Sala;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{
    boolean existsBySalaAndInicioLessThanAndFimGreaterThan(Sala sala, LocalDateTime fimDesejado, LocalDateTime inicioDesejado);
}
