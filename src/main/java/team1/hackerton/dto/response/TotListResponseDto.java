package team1.hackerton.dto.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import team1.hackerton.dto.process.TotListProcessDto;

import java.util.List;

@Getter
@NoArgsConstructor
public class TotListResponseDto {

    private List<TotListProcessDto> response;

    public TotListResponseDto(List<TotListProcessDto> response) {
        this.response = response;
    }
}
