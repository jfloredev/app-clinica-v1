package com.jfloresdev.appclinicav1.pago.respository;


import com.jfloresdev.appclinicav1.pago.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByCitaId(Long citaId);
}