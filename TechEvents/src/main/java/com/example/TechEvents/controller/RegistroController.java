package com.example.TechEvents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroController {

    @GetMapping("/login")
    public String iniciarSesion(){
        return "login";
    }

    /*para que te cargue siempre para hacer login*/
    /*@GetMapping("/")
    public String verPaginaDeInicio(){
        return "login";
    }*/


}
