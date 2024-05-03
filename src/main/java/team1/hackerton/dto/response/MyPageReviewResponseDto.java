package team1.hackerton.dto.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import team1.hackerton.dto.process.MyPageReviewProcessDto;

import java.util.List;

@Getter
@NoArgsConstructor
public class MyPageReviewResponseDto {

    private List<MyPageReviewProcessDto> response;

    public MyPageReviewResponseDto(List<MyPageReviewProcessDto> response) {
        this.response = response;
    }
}
