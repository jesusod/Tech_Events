package com.example.TechEvents.models.repository;

import com.example.TechEvents.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;


public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

    public Usuario findByEmail(String email);

}
