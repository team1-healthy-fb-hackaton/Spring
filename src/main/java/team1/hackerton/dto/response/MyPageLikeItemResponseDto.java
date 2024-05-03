package team1.hackerton.dto.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import team1.hackerton.dto.process.MyPageLikeItemProcessDto;

import java.util.List;

@Getter
@NoArgsConstructor
public class MyPageLikeItemResponseDto {

    List<MyPageLikeItemProcessDto> response;

    public MyPageLikeItemResponseDto(List<MyPageLikeItemProcessDto> response) {
        this.response = response;
    }
}
