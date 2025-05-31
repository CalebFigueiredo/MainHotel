package com.caleb.MainHotel.service;

import com.caleb.MainHotel.model.User;
import com.caleb.MainHotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Método para criar usuário
    public boolean createUser(User user) {
        // Verifica se já existe um usuário com o mesmo email
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return false;  // usuário já existe
        }
        userRepository.save(user);
        return true;


    }


    // Buscar usuário por email
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
