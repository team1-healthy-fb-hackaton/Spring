package team1.hackerton.controller;


import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "로그인", description = "Spring Security, JWT 기반 사용자 인증")
    public ResponseEntity<String> login(
            @Valid @RequestBody LoginRequestDto dto){
        return authService.login(dto);
    }

    @PostMapping("/sign-up")
    @Operation(summary = "회원가입", description = "간단한 형태 - 이메일, 이름, 비밀번호 입력")
    public ResponseEntity<String> signup(
            @Valid @RequestBody SignupRequestDto dto
            ){
        return authService.signup(dto);
    }
}
