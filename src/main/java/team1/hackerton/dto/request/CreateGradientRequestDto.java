package team1.hackerton.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import team1.hackerton.domain.enums.Rate;
import team1.hackerton.domain.enums.Type;

@Getter
@NoArgsConstructor
public class CreateGradientRequestDto {

    private Type type ;
    private String name;
    private String description;
    private Long itemId;

    public CreateGradientRequestDto(Type type, String name, String description, Long itemId) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.itemId = itemId;
    }
}
