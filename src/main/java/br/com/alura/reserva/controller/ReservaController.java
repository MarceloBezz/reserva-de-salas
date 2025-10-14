package br.com.alura.reserva.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.alura.reserva.model.Reserva.ReservaDTO;
import br.com.alura.reserva.model.Usuario.Usuario;
import br.com.alura.reserva.service.ReservaService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private ReservaService service;

    @PostMapping("/agendar")
    public ResponseEntity<String> agendarReserva(@RequestBody @Valid ReservaDTO dto,
            @AuthenticationPrincipal Usuario usuario) {
        service.agendarReserva(dto, usuario);
        return ResponseEntity.ok().body("Reserva de sala concluída!");
    }

}
