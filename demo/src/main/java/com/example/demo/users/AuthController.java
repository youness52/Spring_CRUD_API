package com.example.demo.users;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    
    @PostMapping
    public String loginUser(@RequestBody User user) {
        
        String email=user.getEmail().toString();
        return createToken(email);
    }

    public String createToken( String subject) {
        
        return Jwts.builder()
                //.setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 90000))
                .signWith(SignatureAlgorithm.HS256, "p47FiaxMEi0j6xePfXDQFI4bIFiEFP6S7865RciaNtE")
                .compact();
    }

}
