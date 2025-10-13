package br.com.alura.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.reserva.model.Sala.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long>{
    
}
