package com.example.demo.auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.users.User;
import com.example.demo.users.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;


   @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User authenticationRequest) {
       
        // Retrieve user record from the database based on the provided email
        User user = userRepository.findFirstByEmail(authenticationRequest.getEmail());
        //return ResponseEntity.ok(user);
        //Check if the user exists and if the provided password matches the stored password
        if (user != null && user.getPassword() != null && user.getPassword().equals(authenticationRequest.getPassword().toString())) {
            // Authentication successful
            final String jwt = jwtUtil.generateToken(user.getId(),user.getEmail(),user.getName());
            //AuthResponse authResponse = new AuthResponse(jwt);
            return ResponseEntity.ok(jwt);
        } else {
            // Authentication failed
            authenticationManager.getClass().toString();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed : Email or password incorect" );
            
        }
    }
}

