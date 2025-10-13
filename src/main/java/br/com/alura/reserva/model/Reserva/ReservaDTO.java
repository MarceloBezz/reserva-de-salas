package br.com.alura.reserva.model.Reserva;

import java.time.LocalDateTime;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

public record ReservaDTO(
    @Before(value = fim) LocalDateTime inicio,
    @After(value = inicio) LocalDateTime fim
) {
    
}
