package com.boring.personalfin.service;


import com.auth0.jwt.exceptions.JWTDecodeException;
import com.boring.personalfin.exception.TokenValidationFailedException;
import com.boring.personalfin.exception.UserAlreadyExistException;
import com.boring.personalfin.exception.UserCustomException;
import com.boring.personalfin.exception.UserNotFoundException;
import com.boring.personalfin.model.dao.User;
import com.boring.personalfin.model.dto.AppUserDto;
import com.boring.personalfin.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class AuthenticationService {


    final
    UserRepository userRepository;
    @Autowired
    JwtUtilService jwtUtilService;
    @Autowired
    PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User validate(String token) {
        try {
            User user = userRepository.findUserByEmail(jwtUtilService.getSubjectFromToken(token));
            log.info("Successfully validated token for user {}", user.getEmail());
            return user;
        } catch (JWTDecodeException e) {
            log.error("Error validating token for user with token {}: {}", token, e.getMessage(), e);
            throw new TokenValidationFailedException("Invalid token");
        }
    }

    public String login(String email, String password) {
        User user = userRepository.findUserByEmail(email);
        if (Objects.isNull(user)) throw new UserNotFoundException("User Not Found.");
        if (passwordEncoder.matches(password, user.getPassword())) {
            String token = jwtUtilService.generateToken(email);
            log.info("Successfully logged in user [{}]", email);
            return token;
        } else {
            log.error("Invalid password for user [{}]", user.getEmail());
            throw new UserCustomException("Invalid password");
        }
    }

    public String saveUser(AppUserDto appUserDto) {
        if (userRepository.findUserByEmail(appUserDto.getEmail()) != null) {
            log.error("User Already Exist [{}]", appUserDto.getEmail());
            throw new UserAlreadyExistException("User Already Exist.");
        }
        User user = new User(null, appUserDto.getEmail(), passwordEncoder.encode(appUserDto.getPassword()));
        userRepository.save(user);
        return "done";
    }


}
