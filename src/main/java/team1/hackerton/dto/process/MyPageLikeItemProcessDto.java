package team1.hackerton.dto.process;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MyPageLikeItemProcessDto {

    private Long id;
    private String name;
    private int price;

    public MyPageLikeItemProcessDto(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
