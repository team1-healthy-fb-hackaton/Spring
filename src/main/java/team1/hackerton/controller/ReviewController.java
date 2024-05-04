package team1.hackerton.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import team1.hackerton.dto.request.CreateReviewRequestDto;
import team1.hackerton.dto.response.ListReviewResponseDto;
import team1.hackerton.security.CustomUserDetails;
import team1.hackerton.service.ReviewService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    public final ReviewService reviewService;

    @PostMapping("/write")
    @Operation(summary = "리뷰 작성하기", description = "리뷰 작성하기 50자 이내")
    public ResponseEntity<String> write(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestBody CreateReviewRequestDto dto
            ){
        return reviewService.write(userDetails, dto);
    }

    @GetMapping("/{itemId}")
    @Operation(summary = "리뷰 목록 조회하기", description = "리뷰 목록")
    public ResponseEntity<ListReviewResponseDto> list(
            @PathVariable(name = "itemId") Long id
    ){
        return reviewService.list(id);
    }
}
