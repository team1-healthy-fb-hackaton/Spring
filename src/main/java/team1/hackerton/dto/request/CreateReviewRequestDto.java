package team1.hackerton.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import team1.hackerton.domain.enums.Rate;

@Getter
@NoArgsConstructor
public class CreateReviewRequestDto {

    private Long itemId;
    private Rate rate;
    private boolean tag1;
    private boolean tag2;
    private String content;

    public CreateReviewRequestDto(Long itemId, Rate rate, boolean tag1, boolean tag2, String content) {
        this.itemId = itemId;
        this.rate = rate;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.content = content;
    }
}
