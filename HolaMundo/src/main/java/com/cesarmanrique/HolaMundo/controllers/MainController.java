package com.cesarmanrique.HolaMundo.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String menu(Model model) {
        model.addAttribute("menu", "menu");
        return "menu";
    }

    @GetMapping("/index")
    public String saluda(Model model) {
        model.addAttribute("Index", "Hola Gente");
        return "index";
    }

    @GetMapping("/despedida")
    public String despedida(Model model) {
        model.addAttribute("despedida", "Adios gente");
        return "despedida";
    }

    @GetMapping("/Felicita")
    public String Cumple(Model model) {
        model.addAttribute("Felicita", "Felicita");
        return "felicita";
    }

}