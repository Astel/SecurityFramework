package com.astel.security;

import com.astel.security.dao.UserRepository;
import com.astel.security.model.UserEntity;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;;

@Log4j
@SpringBootApplication
public class Application {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        log.info("Application started");
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        UserEntity user = UserEntity
                .builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .enabled(true)
                .build();

        userRepository.save(user);
    }
}
