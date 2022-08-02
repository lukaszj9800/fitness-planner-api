package pl.jagiela.fitnessplaner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import pl.jagiela.fitnessplaner.model.AuthRequest;
import pl.jagiela.fitnessplaner.util.JwtUtil;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String login() {
        return "Zalogowano";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid Username or Password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }

}
