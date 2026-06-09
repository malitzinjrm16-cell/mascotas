package com.upiiz.mascotas.Repositories;

import com.upiiz.mascotas.Entities.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotasRepository extends JpaRepository<Mascota, Long> {
}