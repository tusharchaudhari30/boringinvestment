package com.boring.personalfin.service;


import com.boring.personalfin.exception.TokenValidationFailedException;
import com.boring.personalfin.exception.UserAlreadyExistException;
import com.boring.personalfin.feign.AuthenticationFeignClient;
import com.boring.personalfin.model.dao.User;
import com.boring.personalfin.model.dto.AppUserDto;
import com.boring.personalfin.repository.UserRepository;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationService {

    final
    AuthenticationFeignClient authFeign;

    final
    UserRepository userRepository;

    public AuthenticationService(AuthenticationFeignClient authFeign, UserRepository userRepository) {
        this.authFeign = authFeign;
        this.userRepository = userRepository;
    }

    public User validate(String token) {
        // Validate token and get user
        try {
            // Find user associated with token
            User user = userRepository.findUserByEmail(authFeign.validateToken(token).getUsername());
            // Log success
            log.info("Successfully validated token for user {}", user.getEmail());
            return user;
        } catch (FeignException e) {
            // Log error
            log.error("Error validating token for user with token {}: {}", token, e.getMessage(), e);
            throw new TokenValidationFailedException("Invalid token");
        }
    }

    public String login(String email, String password) {
        // Log in user and get token
        try {
            // Create AppUserDto with login and password
            AppUserDto appUser = new AppUserDto();
            appUser.setEmail(email);
            appUser.setPassword(password);
            // Log in user and get token
            String token = authFeign.loginuser(appUser).getToken();
            // Log success
            log.info("Successfully logged in user {}", email);
            return token;
        } catch (FeignException e) {
            // Log error
            log.error("Error logging in user {}: {}", email, e.getMessage(), e);
            throw new TokenValidationFailedException("Invalid password");
        }
    }

    public String saveUser(AppUserDto appUserDto) {
        if (userRepository.findUserByEmail(appUserDto.getEmail()) != null) {
            log.error("User Already Exist {}", appUserDto.getEmail());
            throw new UserAlreadyExistException("User Exist");
        }
        //save user in auth service
        authFeign.saveUser(appUserDto);
        //save user in mongodb
        User user = new User(null, appUserDto.getEmail(),appUserDto.getPassword());
        userRepository.save(user);
        return "done";
    }


}
