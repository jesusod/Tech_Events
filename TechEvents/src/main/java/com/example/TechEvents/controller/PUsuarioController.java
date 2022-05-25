package com.example.TechEvents.controller;

import com.example.TechEvents.models.entity.Evento;
import com.example.TechEvents.models.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("user")

public class PUsuarioController {

    @Autowired
    private IEventoService eventoService;

    @GetMapping("")
    public String listadoEventos(Model model) {

        List<Evento> listadoEventos = eventoService.listarTodos();

        model.addAttribute("titulo", "Lista de eventos");
        model.addAttribute("eventos", listadoEventos);

        return "user";

    }
}