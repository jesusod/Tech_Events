package com.example.TechEvents.models.service;

import com.example.TechEvents.models.entity.Usuario;

import java.util.List;

public interface IUsuarioService {


    public List<Usuario> listarTodos();
    public void guardar(Usuario usuario);
    public Usuario buscarporId(Long id);
    public void eliminar(Long id);

}
