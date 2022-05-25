package com.example.TechEvents.controller;

import com.example.TechEvents.models.entity.Evento;
import com.example.TechEvents.models.entity.Usuario;
import com.example.TechEvents.models.service.IEventoService;
import com.example.TechEvents.models.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/views/eventos")
public class EventoController {

    @Autowired
    private IEventoService eventoService;

    @GetMapping("/")
    public String listarEventos(Model model){
        List<Evento> listadoEventos = eventoService.listarTodos();
        model.addAttribute("titulo", "Lista de Eventos");
        model.addAttribute("eventos", listadoEventos);
        return "views/eventos/listar";
    }

    @GetMapping("/create")
    public String crear(Model model){

        Evento evento = new Evento();
        model.addAttribute("titulo", "Formulario: Nuevo Evento");
        model.addAttribute("evento", evento);


        return "views/eventos/frmCrear";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Evento evento){

        eventoService.guardar(evento);
        System.out.println("Evento guardado con exito!");
        return "redirect:/views/eventos/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idEvento, Model model){

        Evento evento = eventoService.buscarporId(idEvento);
        model.addAttribute("titulo", "Formulario: Editar Evento");
        model.addAttribute("evento", evento);

        return "views/eventos/frmCrear";
    }
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idEvento){

       eventoService.eliminar(idEvento);
        System.out.println("El evento se ha eliminado correctamente");

        return "redirect:/views/eventos/";
    }

}