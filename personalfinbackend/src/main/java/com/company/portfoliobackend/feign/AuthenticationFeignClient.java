package com.company.portfoliobackend.feign;

import com.company.portfoliobackend.model.dto.AppUserDto;
import com.company.portfoliobackend.model.dto.AuthenticationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(name = "${AUTH_FEIGN_NAME}", url = "${AUTH_FEIGN_URL}")
public interface AuthenticationFeignClient {
    @GetMapping(value = "${AUTH_FEIGN_VALIDATE_URL}")
    AuthenticationResponse validateToken(@RequestHeader(name = "Authorization") String token);

    @GetMapping(value = "/auth/signin")
    AuthenticationResponse loginuser(@RequestBody AppUserDto appUserDto);

    @PostMapping(value = "/auth/signup")
    AuthenticationResponse saveUser(@RequestBody AppUserDto appUserDto);


}

