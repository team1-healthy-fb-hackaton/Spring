package team1.hackerton.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team1.hackerton.dto.response.MyPageLikeItemResponseDto;
import team1.hackerton.dto.response.MyPageReviewResponseDto;
import team1.hackerton.security.CustomUserDetails;
import team1.hackerton.service.MyPageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {

    public final MyPageService myPageService;

    @GetMapping("/like")
    @Operation(summary = "마이페이지 - 좋아요 목록")
    public ResponseEntity<MyPageLikeItemResponseDto> likeList(
            @AuthenticationPrincipal CustomUserDetails userDetails
            ){
        return myPageService.likeList(userDetails);
    }

    @GetMapping("/reviews")
    @Operation(summary = "마이페이지 - 작성 리뷰 목록")
    public ResponseEntity<MyPageReviewResponseDto> reviewList(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ){
        return myPageService.reviewList(userDetails);
    }


}
