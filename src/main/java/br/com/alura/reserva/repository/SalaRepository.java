package br.com.alura.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.reserva.model.Sala.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long>{
    
}
