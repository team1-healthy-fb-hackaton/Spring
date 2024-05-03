package team1.hackerton.dto.process;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MyPageReviewProcessDto {

    private String company;
    private String name;
    private boolean tag1;
    private boolean tag2;
    private String content;

    public MyPageReviewProcessDto(String company, String name, boolean tag1, boolean tag2, String content) {
        this.company = company;
        this.name = name;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.content = content;
    }
}
