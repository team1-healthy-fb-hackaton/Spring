package team1.hackerton.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import team1.hackerton.domain.Member;
import team1.hackerton.domain.MemberItem;
import team1.hackerton.domain.Review;
import team1.hackerton.dto.process.MyPageLikeItemProcessDto;
import team1.hackerton.dto.process.MyPageReviewProcessDto;
import team1.hackerton.dto.response.MyPageLikeItemResponseDto;
import team1.hackerton.dto.response.MyPageReviewResponseDto;
import team1.hackerton.repository.MemberItemRepository;
import team1.hackerton.repository.MemberRepository;
import team1.hackerton.repository.ReviewRepository;
import team1.hackerton.security.CustomUserDetails;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final MemberRepository memberRepository;
    private final MemberItemRepository memberItemRepository;
    private final ReviewRepository reviewRepository;

    public ResponseEntity<MyPageLikeItemResponseDto> likeList(CustomUserDetails userDetails){
        Long memberId = userDetails.getMemberId();
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new EntityNotFoundException("회원이 존재하지 않습니다."));
        List<MemberItem> likeItemIdList = memberItemRepository.findByMember(member);

        List<MyPageLikeItemProcessDto> processDtos = likeItemIdList.stream().map(memberItem -> new MyPageLikeItemProcessDto(
                memberItem.getItem().getItemId(),
                memberItem.getItem().getName(),
                memberItem.getItem().getPrice())).collect(Collectors.toList());

        return ResponseEntity.ok(new MyPageLikeItemResponseDto(processDtos));
    }

    public ResponseEntity<MyPageReviewResponseDto> reviewList(CustomUserDetails userDetails){
        Long memberId = userDetails.getMemberId();
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new EntityNotFoundException("회원이 존재하지 않습니다."));
        List<Review> reviewList = reviewRepository.findByMember(member);

        List<MyPageReviewProcessDto> processDtos = reviewList.stream().map(review -> new MyPageReviewProcessDto(
                review.getItem().getCompany(),
                review.getItem().getName(),
                review.isTag1(),
                review.isTag2(),
                review.getContent())).collect(Collectors.toList());
        return ResponseEntity.ok(new MyPageReviewResponseDto(processDtos));

    }
}
