package team1.hackerton.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import team1.hackerton.domain.Item;
import team1.hackerton.domain.Member;
import team1.hackerton.domain.Review;
import team1.hackerton.domain.enums.Rate;
import team1.hackerton.dto.process.ListReviewProcessDto;
import team1.hackerton.dto.request.CreateReviewRequestDto;
import team1.hackerton.dto.response.ListReviewResponseDto;
import team1.hackerton.repository.ItemRepository;
import team1.hackerton.repository.MemberRepository;
import team1.hackerton.repository.ReviewRepository;
import team1.hackerton.security.CustomUserDetails;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    public ResponseEntity<String> write(CustomUserDetails userDetails, CreateReviewRequestDto dto){
        Item item = itemRepository.findById(dto.getItemId()).orElseThrow(() -> new EntityNotFoundException("아이템 아이디 존재하지 않습니다."));
        Member member = memberRepository.findById(userDetails.getMemberId()).orElseThrow(() -> new EntityNotFoundException("회원 존재하지않습니다."));
        Review review = new Review(item, member, dto.getContent(), dto.getRate(), dto.isTag1(), dto.isTag2());
        reviewRepository.save(review);
        return ResponseEntity.ok("완료");
    }

    public ResponseEntity<ListReviewResponseDto> list(Long id){
        Item item = itemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("아이템 아이디 존재하지 않습니다."));
        List<Review> reviews = reviewRepository.findByItemOrderByCreatedAtDesc(item);
        List<ListReviewProcessDto> reviewList = reviews.stream().map(review -> new ListReviewProcessDto(
                review.getMember().getName(),
                review.getCreatedAt(),
                review.getContent(),
                review.isTag1(),
                review.isTag2(),
                review.getRate())).collect(Collectors.toList());
        int countTag1 = reviewRepository.findCountTag1(item, true);
        int countTab2 = reviewRepository.findCountTab2(item, true);
        int goodCnt = reviewRepository.findRateCnt(item, Rate.GOOD);
        int sosoCnt = reviewRepository.findRateCnt(item, Rate.SOSO);
        int badCnt = reviewRepository.findRateCnt(item, Rate.BAD);
        ListReviewResponseDto response = new ListReviewResponseDto(countTag1, countTab2, goodCnt, sosoCnt, badCnt, reviewList);
        return ResponseEntity.ok(response);
    }
}
