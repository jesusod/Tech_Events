package com.example.TechEvents.models.service;

import com.example.TechEvents.models.entity.Evento;
import com.example.TechEvents.models.entity.Usuario;
import com.example.TechEvents.models.repository.EventoRepository;
import com.example.TechEvents.models.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements IEventoService{

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> listarTodos() {
        return (List<Evento>) eventoRepository.findAll();
    }

    @Override
    public void guardar(Evento evento) {
        eventoRepository.save(evento);
    }

    @Override
    public Evento buscarporId(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        eventoRepository.deleteById(id);
    }
}