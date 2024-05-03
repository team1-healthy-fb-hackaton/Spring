package team1.hackerton.dto.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import team1.hackerton.dto.process.ListReviewProcessDto;

import java.util.List;

@Getter
@NoArgsConstructor
public class ListReviewResponseDto {

    private int tag1;
    private int tag2;
    private int good;
    private int soso;
    private int bad;
    private List<ListReviewProcessDto> reviewList;

    public ListReviewResponseDto(int tag1, int tag2, int good, int soso, int bad, List<ListReviewProcessDto> reviewList) {
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.good = good;
        this.soso = soso;
        this.bad = bad;
        this.reviewList = reviewList;
    }
}
