package team1.hackerton.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateItemRequestDto {

    private String name;
    private int like_cnt;
    private int price;
    private int zero_kcal;
    private int zero_sugar;
    private Long category_id;
    private String company;

    public CreateItemRequestDto(String name, int price, int zero_kcal, int zero_sugar, Long category_id, String company) {
        this.name = name;
        this.like_cnt = 0;
        this.price = price;
        this.zero_kcal = zero_kcal;
        this.zero_sugar = zero_sugar;
        this.category_id = category_id;
        this.company = company;
    }
}
