package com.example.TechEvents.models.repository;

import com.example.TechEvents.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {


}