package br.com.alura.reserva.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.reserva.infra.exception.RegraDeNegocioException;
import br.com.alura.reserva.model.Reserva.ReservaDTO;
import br.com.alura.reserva.model.Sala.Sala;
import br.com.alura.reserva.repository.ReservaRepository;

@Component
public class ValidarSalaJaAgendada implements IValidacaoReserva{

    @Autowired
    private ReservaRepository repository;

    @Override
    public void validar(Sala sala, ReservaDTO dto) {
        if (repository.existsBySalaAndInicioLessThanAndFimGreaterThan(sala, dto.fim(), dto.inicio()))
            throw new RegraDeNegocioException("A sala já está reservada neste horário! Favor consultar horários disponíveis");
    }
     
}
