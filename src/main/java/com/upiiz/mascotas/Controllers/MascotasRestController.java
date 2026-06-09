package com.upiiz.mascotas.Controllers;

import com.upiiz.mascotas.Entities.Mascota;
import com.upiiz.mascotas.Repositories.MascotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotasRestController {

    @Autowired
    private MascotasRepository repository;

    @GetMapping
    public ResponseEntity<List<Mascota>> listarTodas() {
        List<Mascota> mascotas = repository.findAll();
        return ResponseEntity.ok(mascotas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> obtenerPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mascota> guardar(@RequestBody Mascota mascota) {
        Mascota nuevaMascota = repository.save(mascota);
        return ResponseEntity.ok(nuevaMascota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizar(@PathVariable Long id, @RequestBody Mascota mascota) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        mascota.setId(id);
        Mascota mascotaActualizada = repository.save(mascota);
        return ResponseEntity.ok(mascotaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}