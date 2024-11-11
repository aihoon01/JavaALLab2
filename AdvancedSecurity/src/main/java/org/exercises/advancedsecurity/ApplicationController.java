package org.exercises.advancedsecurity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @GetMapping
    public String hello() {
        return "Hello World";
    }

    @GetMapping("profile")
    public String profile(@AuthenticationPrincipal OidcUser principal) {
        String user="";
        System.out.println(principal);
        if (principal != null) {user = principal.getGivenName() + "\n" + principal.getEmail();}
        return "Hello Welcome to the protected profile page!s" +" \n" + user;
    }
}
