package team1.hackerton.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateCategoryRequestDto {

    private String name;
    private String url;

    public CreateCategoryRequestDto(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
