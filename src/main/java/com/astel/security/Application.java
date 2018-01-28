package com.astel.security;

import com.astel.security.dao.UserRepository;
import com.astel.security.model.UserEntity;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;;

@Log4j
@SpringBootApplication
public class Application {
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        UserEntity user = UserEntity
                .builder()
                .username("admin")
                .password("admin")
                .build();

        userRepository.save(user);
    }
}
