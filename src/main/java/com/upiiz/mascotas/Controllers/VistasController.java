package com.upiiz.mascotas.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistasController {

    // 1. Esta ruta responderá cuando escribas /mascotas al final de la URL
    @GetMapping("/mascotas")
    public String mascotas() {
        return "mascotas"; // Busca el archivo templates/mascotas.html
    }

    // 2. AGREGA ESTO: Redirige automáticamente la raíz (/) hacia /mascotas
    @GetMapping("/")
    public String raiz() {
        return "redirect:/mascotas";
    }
}