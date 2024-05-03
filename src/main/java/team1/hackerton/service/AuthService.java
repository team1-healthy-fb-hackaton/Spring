package team1.hackerton.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import team1.hackerton.domain.Member;
import team1.hackerton.dto.request.LoginRequestDto;
import team1.hackerton.dto.request.SignupRequestDto;
import team1.hackerton.repository.MemberRepository;
import team1.hackerton.security.JwtUtil;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;

    public ResponseEntity<String> login(LoginRequestDto dto){
        Member member = memberRepository.findByEmail(dto.getEmail()).orElseThrow(
                () -> new EntityNotFoundException("이메일 존재하지 않음")
        );
        if (member.getPwd().equals(dto.getPwd())){
            String accessToken = jwtUtil.createToken(member.getId());
            return ResponseEntity.ok(accessToken);
        }
        else {
            return ResponseEntity.badRequest().body("비밀번호 불일치");
        }

    }

    public ResponseEntity<String> signup(SignupRequestDto dto){
        Member member = new Member(dto.getEmail(), dto.getPwd(), dto.getName());
        memberRepository.save(member);
        return ResponseEntity.ok("성공");
    }

}
