package team1.hackerton.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team1.hackerton.dto.request.LoginRequestDto;
import team1.hackerton.dto.request.SignupRequestDto;
import team1.hackerton.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @Valid @RequestBody LoginRequestDto dto){
        return authService.login(dto);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signup(
            @Valid @RequestBody SignupRequestDto dto
            ){
        return authService.signup(dto);
    }
}
