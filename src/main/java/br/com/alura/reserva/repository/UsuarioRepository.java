package br.com.alura.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.reserva.model.Usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
