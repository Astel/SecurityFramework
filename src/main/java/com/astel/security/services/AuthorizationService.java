package com.astel.security.services;

import com.astel.stand.dao.UserRepository;
import com.astel.stand.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(UserEntity user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void delete(UserEntity user) {
        userRepository.delete(user);
    }

    public void update(UserEntity user) {
        UserEntity oldUser = userRepository.getOne(user.getId());
        if (!user.getUsername().isEmpty()) {
            oldUser.setUsername(user.getUsername());
        }
        if (!user.getPassword().isEmpty()) {
            oldUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        userRepository.save(oldUser);
    }
}
