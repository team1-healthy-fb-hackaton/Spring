package team1.hackerton.dto.process;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class ItemDetailProcessDto {

    private Long itemId;
    private int zeroSugar;
    private int zeroKcal;
    private String itemUrl;
    private String company;
    private String store;
    private String name;
    private int price;
    private String nutritionUrl;
    private int like;
    private String infoUrl;

    @Builder
    public ItemDetailProcessDto(Long itemId, int zeroSugar, int zeroKcal, String itemUrl, String company, String store, String name, int price, String nutritionUrl, int like, String infoUrl) {
        this.itemId = itemId;
        this.zeroSugar = zeroSugar;
        this.zeroKcal = zeroKcal;
        this.itemUrl = itemUrl;
        this.company = company;
        this.store = store;
        this.name = name;
        this.price = price;
        this.nutritionUrl = nutritionUrl;
        this.like = like;
        this.infoUrl = infoUrl;
    }
}
