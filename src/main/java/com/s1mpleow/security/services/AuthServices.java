package com.s1mpleow.security.services;

import com.s1mpleow.security.dtos.AuthenticationResponseDTO;
import com.s1mpleow.security.dtos.RegisterDTO;
import com.s1mpleow.security.models.user.IUserRepository;
import com.s1mpleow.security.models.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServices {
    private final IUserRepository userRepository;

    private  final PasswordEncoder passwordEncoder;

    private  final JwtServices jwtServices;
    public AuthenticationResponseDTO register(RegisterDTO registerDTO) {
        var user = User.builder()
                .email(registerDTO.getEmail())
                .firstname(registerDTO.getFirstname())
                .lastname(registerDTO.getLastname())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .build();

        userRepository.save(user);
        String token = jwtServices.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(token)
                .build();
    }
}
