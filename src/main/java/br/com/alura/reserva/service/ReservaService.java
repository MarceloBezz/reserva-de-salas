package br.com.alura.reserva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.reserva.infra.exception.RegraDeNegocioException;
import br.com.alura.reserva.model.Reserva.Reserva;
import br.com.alura.reserva.model.Reserva.ReservaDTO;
import br.com.alura.reserva.model.Sala.Sala;
import br.com.alura.reserva.model.Usuario.Usuario;
import br.com.alura.reserva.repository.ReservaRepository;
import br.com.alura.reserva.repository.SalaRepository;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repository;

    @Autowired
    private SalaRepository salaRepository;

    public void agendarReserva(ReservaDTO dados, Usuario usuario) {
        Sala salaDesejada = salaRepository.findById(dados.salaId())
                .orElseThrow(() -> new RegraDeNegocioException("Sala não encontrada!"));

        //TODO Deixar essas validações em uma interface de validações separada
        if (!salaDesejada.isAtiva())
            throw new RegraDeNegocioException("A sala desejada não está ativa! Favor selecionar outra que esteja");
        
        if (repository.existsBySalaAndInicioLessThanAndFimGreaterThan(salaDesejada, dados.fim(), dados.inicio()))
            throw new RegraDeNegocioException("A sala já está reservada neste horário! Favor consultar horários disponíveis");

        if  (salaDesejada.getCapacidade() < dados.quantidade())
            throw new RegraDeNegocioException("Capacidade da sala excedida!");
        
        Reserva reserva = new Reserva(dados, usuario, salaDesejada);
        repository.save(reserva);
    }
}
