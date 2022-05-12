package com.example.TechEvents.models.service;

import com.example.TechEvents.dto.UsuarioRegistroDTO;
import com.example.TechEvents.models.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUsuarioService extends UserDetailsService {

    public List<Usuario> listarTodos();
    public void guardar(Usuario usuario);
    public Usuario buscarporId(Long id);
    public void eliminar(Long id);
    public Usuario guardar(UsuarioRegistroDTO registroDTO);
}
