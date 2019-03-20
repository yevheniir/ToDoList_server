package com.yevhenii.to_do_list.controller;

import com.yevhenii.to_do_list.service.TokenUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthorizationRESTController {

    @GetMapping("/token")
    public String getToken(@AuthenticationPrincipal TokenUserDetails principal) {
        System.out.println(principal);
        return principal.getToken();
    }

    @GetMapping("/user")
    public TokenUserDetails getUser(@AuthenticationPrincipal TokenUserDetails principal) {
        System.out.println(principal);
        return principal;
    }
}