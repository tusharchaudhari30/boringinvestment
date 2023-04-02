package com.boring.personalfin.controller;


import com.boring.personalfin.model.dao.Assets;
import com.boring.personalfin.model.dto.AppUserDto;
import com.boring.personalfin.model.dto.Portfolio;
import com.boring.personalfin.repository.AssetRepository;
import com.boring.personalfin.service.AuthenticationService;
import com.boring.personalfin.service.PortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    final
    AuthenticationService authenticationService;

    final
    AssetRepository assetRepository;

    final
    PortfolioService portfolioService;

    public UserController(AuthenticationService authenticationService, AssetRepository assetRepository, PortfolioService portfolioService) {
        this.authenticationService = authenticationService;
        this.assetRepository = assetRepository;
        this.portfolioService = portfolioService;
    }


    @GetMapping("/user")
    public ResponseEntity<?> hello(@RequestHeader("Authorization") String token) {
        token = token.substring(7);
        return ResponseEntity.ok(authenticationService.validate(token));
    }

    @GetMapping("/user/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(authenticationService.login(email, password));
    }

    @PostMapping("/user/signup")
    public ResponseEntity<?> signUpUser(@RequestBody AppUserDto appUserDto) {
        return ResponseEntity.ok(authenticationService.saveUser(appUserDto));
    }

    @GetMapping("/asset/search")
    public List<Assets> searchAssetByName(@RequestParam String keyword) {
        return assetRepository.findByAssetNameContainingIgnoreCase(keyword);
    }

    @GetMapping("/portfolio")
    public Portfolio getPortfolio(@RequestHeader("Authorization") String token) {
        return portfolioService.getPortfolio(token);
    }
}
