package ru.micro.demo.authenticateservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.micro.demo.authenticateservice.data.model.UserCredential;
import ru.micro.demo.authenticateservice.data.repository.UserCredentialRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserCredentialRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    public String saveUser(UserCredential userCredential){
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        repository.save(userCredential);
        return "user added to system";
    }

    public String generateToken(String username){
        return jwtService.generateToken(username);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }
}
