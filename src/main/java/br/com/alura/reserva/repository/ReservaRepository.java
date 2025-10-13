package br.com.alura.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.reserva.model.Reserva.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
    
}
