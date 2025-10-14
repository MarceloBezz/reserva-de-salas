package br.com.alura.reserva.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.reserva.model.Sala.SalaDTO;
import br.com.alura.reserva.service.SalaService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    private SalaService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarSala(@RequestBody @Valid SalaDTO dados) {
        service.criarSala(dados);
        return ResponseEntity.ok().body("Sala criada com sucesso!");
    }
    
}
