package br.com.alura.reserva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.reserva.model.Sala.Sala;
import br.com.alura.reserva.model.Sala.SalaDTO;
import br.com.alura.reserva.repository.SalaRepository;

@Service
public class SalaService {
    @Autowired
    private SalaRepository repository;

    public void criarSala(SalaDTO dto) {
        Sala sala = new Sala(dto);
        repository.save(sala);
    }
}
