package team1.hackerton.converter;

import org.springframework.beans.factory.annotation.Value;
import team1.hackerton.domain.Gradient;
import team1.hackerton.domain.Item;
import team1.hackerton.dto.response.ItemDetailResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ItemDetailConverter {

    @Value("${cloud.aws.s3.uploadPath}")
    private static String defaultUrl;



    public static ItemDetailResponseDto.ItemDetailDto toDto(Item item, List<Gradient> gradientList, boolean like){
        List<ItemDetailResponseDto.GradientDto> gradientDto =  toDtoList(gradientList);

        return ItemDetailResponseDto.ItemDetailDto.builder()
                .itemId(item.getItemId())
                .zeroSugar(item.isZeroSugar())
                .zeroKcal(item.isZeroKcal())
                .itemUrl(defaultUrl+item.getUrl())
                .company(item.getCompany())
                .store(item.getStore())
                .createdAt(item.getCreatedAt())
                .updatedAt(item.getUpdatedAt())
                .name(item.getName())
                .price(item.getPrice())
                .nutritionUrl(defaultUrl+item.getNutritionUrl())
                .gradientCnt(item.getGradientList().size())
                .infoUrl(defaultUrl+item.getInfoUrl())
                .like(like)
                .gradientDto(gradientDto)
                .build();
    }

    private static List<ItemDetailResponseDto.GradientDto> toDtoList(List<Gradient> gradientList) {

        return gradientList.stream()
                .map(gradient -> ItemDetailResponseDto.GradientDto.builder()
                        .gradientId(gradient.getGradientId())
                        .itemId(gradient.getItem().getItemId())
                        .name(gradient.getName())
                        .description(gradient.getDescription())
                        .type(gradient.getType())
                        .build())
                .collect(Collectors.toList());
    }

}

