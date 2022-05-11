package com.example.TechEvents.controller;

import com.example.TechEvents.models.entity.Evento;
import com.example.TechEvents.models.entity.Usuario;
import com.example.TechEvents.models.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/views/usuarios/")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;


    @GetMapping("/")
    public String listarUsuarios(Model model){
        List<Usuario> listadoUsuarios = usuarioService.listarTodos();
        model.addAttribute("titulo", "Lista de Usuarios");
        model.addAttribute("usuarios", listadoUsuarios);
        return "views/usuarios/listar";
    }

    @GetMapping("/create")
    public String crear(Model model){

        Usuario usuario = new Usuario();
        model.addAttribute("titulo", "Formulario: Nuevo Usuario");
        model.addAttribute("usuario", usuario);

        return "views/usuarios/frmCrear";
    }
    @PostMapping("/save")
    public String guardar(@ModelAttribute Usuario usuario, BindingResult result, Model model){

        if(result.hasErrors()){

            model.addAttribute("titulo", "Formulario: Nuevo Usuario");
            model.addAttribute("usuario", usuario);

            return "views/usuarios/frmCrear";

        }

        usuarioService.guardar(usuario);
        System.out.println("Usuario guardado con exito!");
        return "redirect:/views/usuarios/";
    }
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idUsuario, Model model){

        Usuario usuario = usuarioService.buscarporId(idUsuario);
        model.addAttribute("titulo", "Formulario: Editar Usuario");
        model.addAttribute("usuario", usuario);


        return "views/usuarios/frmCrear";
    }
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idUsuario){

        usuarioService.eliminar(idUsuario);
        System.out.println("El usuario se ha eliminado correctamente");

        return "redirect:/views/usuarios/";
    }

}
