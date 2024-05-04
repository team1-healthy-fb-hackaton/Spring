package team1.hackerton.dto.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import team1.hackerton.domain.Gradient;
import team1.hackerton.dto.process.ItemDetailProcessDto;

import java.util.List;

@Getter
@NoArgsConstructor
public class ItemDetailResponseDto {

    private ItemDetailProcessDto detail;
    private List<Gradient> gradientList;

    public ItemDetailResponseDto(ItemDetailProcessDto detail, List<Gradient> gradientList) {
        this.detail = detail;
        this.gradientList = gradientList;
    }
}
