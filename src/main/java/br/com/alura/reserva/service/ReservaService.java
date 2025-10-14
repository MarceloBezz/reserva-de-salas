package br.com.alura.reserva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.reserva.infra.exception.RegraDeNegocioException;
import br.com.alura.reserva.model.Reserva.Reserva;
import br.com.alura.reserva.model.Reserva.ReservaDTO;
import br.com.alura.reserva.model.Sala.Sala;
import br.com.alura.reserva.model.Usuario.Usuario;
import br.com.alura.reserva.repository.ReservaRepository;
import br.com.alura.reserva.repository.SalaRepository;
import br.com.alura.reserva.validacoes.IValidacaoReserva;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repository;

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private List<IValidacaoReserva> validadores;

    public void agendarReserva(ReservaDTO dados, Usuario usuario) {
        Sala salaDesejada = salaRepository.findById(dados.salaId())
                .orElseThrow(() -> new RegraDeNegocioException("Sala não encontrada!"));

        validadores.forEach(v -> v.validar(salaDesejada, dados));
        
        Reserva reserva = new Reserva(dados, usuario, salaDesejada);
        repository.save(reserva);
    }
}
