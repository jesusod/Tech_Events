package com.example.TechEvents.models.service;

import com.example.TechEvents.models.entity.Evento;


import java.util.List;

public interface IEventoService {

    public List<Evento> listarTodos();
    public void guardar(Evento evento);
    public Evento buscarporId(Long id);
    public void eliminar(Long id);


}