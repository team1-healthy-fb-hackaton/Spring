package team1.hackerton.dto.response;

import lombok.Builder;
import team1.hackerton.domain.Gradient;

import java.time.LocalDateTime;
import java.util.List;

public class ItemDetailResponseDto {

    @Builder
    public static class ItemDetailDto{

        private Long itemId;

        private boolean zeroSugar;

        private boolean zeroKcal;

        private String itemUrl;

        private String company;

        private String store;

        private String name;

        private int price;

        private String nutritionUrl;

        private int gradientCnt;

        private boolean like;


        private String infoUrl;

        private LocalDateTime createdAt;

        private LocalDateTime updatedAt;

        private List<GradientDto> gradientDto;
    }

    @Builder
    public static class GradientDto{
        private Long gradientId;

        private Long itemId;

        private String name;

        private String description;

        private int type;

    }

}
