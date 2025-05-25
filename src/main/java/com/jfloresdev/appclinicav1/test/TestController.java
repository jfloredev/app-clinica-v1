package com.jfloresdev.appclinicav1.test;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/privado")
    public String privado() {
        return "✅ Acceso autorizado. ¡Hola, estás autenticado!";
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
