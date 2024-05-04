package team1.hackerton.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeItemRequestDto {

    private Long id;

    public LikeItemRequestDto(Long id) {
        this.id = id;
    }
}
