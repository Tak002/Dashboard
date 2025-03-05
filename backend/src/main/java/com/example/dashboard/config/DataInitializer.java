package com.example.dashboard.config;

import com.example.dashboard.entity.User;
import com.example.dashboard.repository.UserRepository;
import com.example.dashboard.role.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer
{
    @Bean
    public CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder){
        return args -> {
            String newEmail = "abcde@email.com";
            String password= "anypassword";
            Role role = Role.ROLE_USER;
            if (userRepository.existsUserByEmail(newEmail)) return;
            userRepository.save(User.builder().email(newEmail).password(passwordEncoder.encode(password)).role(role).build());


        };
    }
}
