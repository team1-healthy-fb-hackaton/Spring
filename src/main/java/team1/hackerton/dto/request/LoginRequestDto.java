package team1.hackerton.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequestDto {

    private String email;
    private String pwd;

    public LoginRequestDto(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }
}
