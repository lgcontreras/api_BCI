package org.example.bci_api.service;

import org.example.bci_api.model.User;
import org.example.bci_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) throws Exception {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new Exception("El correo ya está registrado.");
        }

        user.setId(UUID.randomUUID());
        user.setCreated(String.valueOf(System.currentTimeMillis()));

        return userRepository.save(user);
    }
}
