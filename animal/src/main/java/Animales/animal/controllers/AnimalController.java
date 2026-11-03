package Animales.animal.controllers;

import jakarta.validation.Valid;
import Animales.animal.models.animal;
import Animales.animal.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class AnimalController {
    /*AnimalService service;
    public AnimalController(AnimalService service) {
        this.service = service;
    }*/

    @Autowired
    AnimalService as1;

    @GetMapping("/animals")
    public String menu(Model model) {
        model.addAttribute("animals", as1.findAll());
        return "/animals/menu";
    }
    @GetMapping("/animals/{id}")
    public String obId(@PathVariable int id, Model model) {
        animal Animal = as1.findById(id);
        model.addAttribute("animal", Animal);
        return "/animals/details";
    }
    @GetMapping("/animals/crear")
    public String crear (Model model){
        model.addAttribute("animal", new animal());
        return "/animals/crear";
    }
    @PostMapping("/animals/crear")
    public String crear (@Valid @ModelAttribute("animal") animal animal, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "animals/crear";
        }else{
            as1.guardar(animal);
            return  "redirect:/animals";
        }
    }
    @GetMapping("/animals/edit/{id}")
    public String edit (@PathVariable int id, Model model){
        animal a = as1.findById(id);
        model.addAttribute("animal", a);
        return "/animals/edit";
    }
    @PostMapping("/animals/edit/{id}")
    public String edit(@PathVariable("id") int id, @Valid @ModelAttribute("animal") animal an, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "animals/edit";
        } else {
            an.setId(id);
            as1.actualizar(id, an);
            return "redirect:/animals";
        }
    }
    @GetMapping("/animals/borrar/{id}")
    public String eliminar (@PathVariable int id, Model model){
        as1.eliminar(id);
        return "redirect:/animals";
    }
}

