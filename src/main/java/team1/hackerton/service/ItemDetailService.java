package team1.hackerton.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import team1.hackerton.converter.ItemDetailConverter;
import team1.hackerton.domain.Gradient;
import team1.hackerton.domain.Item;
import team1.hackerton.domain.Member;
import team1.hackerton.domain.MemberItem;
import team1.hackerton.dto.response.ItemDetailResponseDto;
import team1.hackerton.repository.GradientRepository;
import team1.hackerton.repository.ItemRepository;
import team1.hackerton.repository.MemberItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemDetailService {

    private ItemRepository itemRepository;

    private GradientRepository gradientRepository;

    private MemberItemRepository memberItemRepository;


    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.s3.uploadPath}")
    private String defaultUrl;

    public ItemDetailResponseDto.ItemDetailDto readItemDetail(Member member, Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new EntityNotFoundException("에러"));

        List<Gradient> gradientList = gradientRepository.findByItem(item);


        MemberItem memberItem = memberItemRepository.findByMemberAndItem(member, item);
        if (memberItem.getItem() == null) {
            return ItemDetailConverter.toDto(item, gradientList, false);
        }

        return ItemDetailConverter.toDto(item, gradientList, true);
    }


}
