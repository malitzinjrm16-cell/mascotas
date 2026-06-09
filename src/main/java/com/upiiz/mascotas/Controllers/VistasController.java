package com.upiiz.mascotas.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistasController {

    @GetMapping("/mantenimiento-mascotas")
    public String mostrarMascotas() {
        return "mascotas";
    }

    @GetMapping("/")
    public String redirigir() {
        return "redirect:/mascotas";
    }
}