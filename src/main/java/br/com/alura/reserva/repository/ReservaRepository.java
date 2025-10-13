package br.com.alura.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.reserva.model.Reserva.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{
    
}
