package team1.hackerton.dto.process;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TotListProcessDto {

    private String name;
    private String url;

    public TotListProcessDto(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
