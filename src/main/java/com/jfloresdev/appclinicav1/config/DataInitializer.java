package com.jfloresdev.appclinicav1.config;

import com.jfloresdev.appclinicav1.usuario.entity.User;
import com.jfloresdev.appclinicav1.usuario.repository.UserRepository;
import com.jfloresdev.appclinicav1.common.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                userRepository.save(User.builder()
                        .username("admin")
                        .password(encoder.encode("admin123"))
                        .role(Role.ADMIN)
                        .enabled(true)
                        .build());
                System.out.println("✅ Usuario ADMIN creado: admin/admin123");
            }
        };
    }
}