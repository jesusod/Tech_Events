package com.example.TechEvents.controller;

import com.example.TechEvents.dto.UsuarioRegistroDTO;
import com.example.TechEvents.models.service.IUsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioController {

    private IUsuarioService iUsuarioService;

    public RegistroUsuarioController(IUsuarioService iUsuarioService) {
        super();
        this.iUsuarioService = iUsuarioService;
    }
    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO(){

        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro(){
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO){

        iUsuarioService.guardar(registroDTO);
        return "redirect:/registro?exito";
    }



}
