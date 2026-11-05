package Javi.Animales.controller;

import Javi.Animales.models.Animal;
import Javi.Animales.services.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimalController {
    //Forma1 de inyectar dependencias en spring
    @Autowired
    AnimalService as1;

    //Forma 2 de inyectar dependencias en spring)

    /*AnimalService service;
    public AnimalController(AnimalService service){
        this.service = service;
    }*/

    @GetMapping("animals/index")
    public String listarAnimales(Model model) {
        model.addAttribute("animales", as1.findAll());
        return "animals/index";
    }

    @GetMapping("/animals/{id}")
    public String obtenerId(@PathVariable int id, Model model) {
        Animal animal = as1.findById(id);
        model.addAttribute("animal", animal);
        return "animals/detail";
    }

    @GetMapping("/animals/crear")
    public String crear(Model model) {
        model.addAttribute("animal", new Animal());
        return "/animals/crear";
    }

    @PostMapping("/animals/crear")
    public String crearAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "/animals/crear";
        } else {
            as1.guardar(animal);
            return "redirect:/animals/index";
        }
    }
    @GetMapping("/animals/borrar/{id}")
    public String eliminarAnimal(@PathVariable("id") int id, Model model) {
       Animal animal= as1.findById(id);
       model.addAttribute("animal", animal);

        return "animals/borrar";
    }
    @PostMapping("/animals/borrar/{id}")
    public String confirmarBorrar(@PathVariable("id")int id) {
        as1.eliminar(id);
        return "redirect:/animals/index";
    }
    @GetMapping("/animals/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int id, Model model) {
        // 1. Buscas el animal en tu lista/servicio por su ID
        Animal animal = as1.findById(id);

        // 2. Lo añades al modelo para que Thymeleaf lo reconozca en el HTML
        model.addAttribute("animal", animal);

        // 3. Devuelves la ruta de tu archivo HTML de editar (ej: "animals/editar" o "editar")
        return "animals/editar";
    }
    @PostMapping("/animals/actualizar")
    public String actualizarAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Si hay errores de validación, vuelve a la vista de editar y NO actualiza
            return "animals/editar";
        } else {
            as1.actualizar(animal);
            return "redirect:/animals/index";
        }
    }
}

