package team1.hackerton.dto.process;


import team1.hackerton.domain.enums.Rate;

import java.time.LocalDateTime;

public class ListReviewProcessDto {

    private String name;
    private LocalDateTime createAt;
    private String content;
    private boolean tag1;
    private boolean tag2;
    private Rate rate;

    public ListReviewProcessDto(String name, LocalDateTime createAt, String content, boolean tag1, boolean tag2, Rate rate) {
        this.name = name;
        this.createAt = createAt;
        this.content = content;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.rate = rate;
    }
}
