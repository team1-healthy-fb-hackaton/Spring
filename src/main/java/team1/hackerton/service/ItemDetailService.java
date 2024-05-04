package team1.hackerton.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import team1.hackerton.domain.*;
import team1.hackerton.dto.process.TotListProcessDto;
import team1.hackerton.dto.request.CreateCategoryRequestDto;
import team1.hackerton.dto.request.CreateItemRequestDto;
import team1.hackerton.dto.request.LikeItemRequestDto;
import team1.hackerton.dto.response.ItemDetailResponseDto;
import team1.hackerton.dto.response.TotListResponseDto;
import team1.hackerton.repository.*;
import team1.hackerton.security.CustomUserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemDetailService {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final GradientRepository gradientRepository;
    private final CategoryRepository categoryRepository;
    private final MemberItemRepository memberItemRepository;


    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.s3.uploadPath}")
    private String defaultUrl;

//    public ResponseEntity<ItemDetailResponseDto.ItemDetailDto> readItemDetail(CustomUserDetails userDetails, Long itemId) {
//        Long memberId = userDetails.getMemberId();
//        Member member = memberRepository.findById(memberId).orElseThrow(() -> new EntityNotFoundException("에러"));
//        Item item = itemRepository.findById(itemId).orElseThrow(() -> new EntityNotFoundException("에러"));
//
//        List<Gradient> gradientList = gradientRepository.findByItem(item);
//
//
//        MemberItem memberItem = memberItemRepository.findByMemberAndItem(member, item);
//        if (memberItem.getItem() == null) {
//            ItemDetailResponseDto.ItemDetailDto dto = ItemDetailConverter.toDto(item, gradientList, false);
//            return ResponseEntity.ok(dto);
//        }
//
//        ItemDetailResponseDto.ItemDetailDto dto = ItemDetailConverter.toDto(item, gradientList, true);
//        return ResponseEntity.ok(dto);
//    }

    public ResponseEntity<String> likeItem(CustomUserDetails userDetails, LikeItemRequestDto dto){
        Long memberId = userDetails.getMemberId();
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new EntityNotFoundException("에러"));
        Item item = itemRepository.findById(dto.getId()).orElseThrow(() -> new EntityNotFoundException("에러"));

        MemberItem newLike = new MemberItem(member, item);
        memberItemRepository.save(newLike);
        return ResponseEntity.ok("성공");
    }

    public ResponseEntity<TotListResponseDto> list(CustomUserDetails userDetails){
        List<TotListProcessDto> arr1 = new ArrayList<>();
        arr1.add(new TotListProcessDto("실론티 레몬 제로 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/9.jpg"));
        arr1.add(new TotListProcessDto("환타 제로 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/images.jpg"));
        arr1.add(new TotListProcessDto("파워에이드 제로 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/2.jpg"));
        arr1.add(new TotListProcessDto("웰치제로 오렌지맛 그레이프맛 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/3.jpg"));
        arr1.add(new TotListProcessDto("비타 500 제로 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/5.jpg"));
        arr1.add(new TotListProcessDto("밀키스 제로 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/milkisZero_01_250.jpg"));
        arr1.add(new TotListProcessDto("밀키스 딸기 바나나 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/11.jpg"));
        arr1.add(new TotListProcessDto("펩시 제로 슈가 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/12.jpg"));
        arr1.add(new TotListProcessDto("밀키스 딸기 바나나 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/9.jpg"));

        arr1.add(new TotListProcessDto("라라스윗 파인트 초코 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/22.jpg"));
        arr1.add(new TotListProcessDto("라라스윗 저당 생크림롤 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/23.jpg"));
        arr1.add(new TotListProcessDto("라라스윗 초콜릿 모나카 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/24.jpg"));
        arr1.add(new TotListProcessDto("곤약 물냉면 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/41.jpg"));
        arr1.add(new TotListProcessDto("저당불고기 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/51.jpg"));
        arr1.add(new TotListProcessDto("몽쉘 제로 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/52.jpgg"));
        arr1.add(new TotListProcessDto("저칼로리 데리야끼 소스 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/42.jpg"));
        arr1.add(new TotListProcessDto("제로 초콜릿 쿠키  ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/090635.png"));
        arr1.add(new TotListProcessDto("저당 크래커 아이비 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/090851.png"));
        arr1.add(new TotListProcessDto("라라스윗 파인트 초코 ", "https://zzero-bucket.s3.ap-northeast-2.amazonaws.com/22.jpg"));

        return ResponseEntity.ok(new TotListResponseDto(arr1));
    }

    public ResponseEntity<String> addCategory(CustomUserDetails userDetails, CreateCategoryRequestDto dto){
        Category category = new Category(dto.getName(), dto.getUrl());
        categoryRepository.save(category);
        return ResponseEntity.ok("ok");
    }

    public ResponseEntity<String> addItem(CreateItemRequestDto dto){
        Category category = categoryRepository.findById(dto.getCategory_id()).orElseThrow(() -> new EntityNotFoundException("에러"));
        Item item = new Item(dto.getLike_cnt(), dto.getPrice(), dto.getZero_kcal(), dto.getZero_sugar(), category, dto.getCompany());
        itemRepository.save(item);
        return ResponseEntity.ok("ok");
    }

}
