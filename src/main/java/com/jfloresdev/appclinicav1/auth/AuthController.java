package com.jfloresdev.appclinicav1.auth;


import com.jfloresdev.appclinicav1.usuario.entity.User;
import com.jfloresdev.appclinicav1.usuario.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        try {
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            User user = (User) auth.getPrincipal();
            return jwtService.generateToken(user.getUsername());

        } catch (AuthenticationException e) {
            return "Credenciales inválidas";
        }
    }
}
