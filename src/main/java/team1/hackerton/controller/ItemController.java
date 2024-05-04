package team1.hackerton.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import team1.hackerton.dto.request.CreateCategoryRequestDto;
import team1.hackerton.dto.request.CreateGradientRequestDto;
import team1.hackerton.dto.request.CreateItemRequestDto;
import team1.hackerton.dto.request.LikeItemRequestDto;
import team1.hackerton.dto.response.ItemDetailResponseDto;
import team1.hackerton.dto.response.TotListResponseDto;
import team1.hackerton.security.CustomUserDetails;
import team1.hackerton.service.ItemDetailService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemDetailService itemDetailService;

    @PostMapping("/addCategory")
    @Operation(summary = "카테고리 생성", description = "카테고리 생성")
    public ResponseEntity<String> addCategory(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestBody CreateCategoryRequestDto dto
            ){
        return itemDetailService.addCategory(userDetails, dto);
    }

    @PostMapping("/addItem")
    @Operation(summary = "상품 생성", description = "상품 생성")
    public ResponseEntity<String> addItem(
            @RequestBody CreateItemRequestDto dto
            ){
        return itemDetailService.addItem(dto);
    }

    @PostMapping("/addGredient")
    @Operation(summary = "성분 생성", description = "성분 생성")
    public ResponseEntity<String> addGradient(
            @RequestBody CreateGradientRequestDto dto
    ){
        return itemDetailService.addGradient(dto);
    }


    @Operation(summary = "상품 상세 목록")
    @GetMapping("/detail/{itemId}")
    public ResponseEntity<ItemDetailResponseDto> readItemDetail(@AuthenticationPrincipal CustomUserDetails userDetails, @PathVariable(name="itemId") Long itemId){
        return itemDetailService.readItemDetail(userDetails, itemId);
    }

    @PostMapping("/detail")
    @Operation(summary = "상품 좋아요")
    public ResponseEntity<String> likeItem(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestBody LikeItemRequestDto dto
            ){
        return itemDetailService.likeItem(userDetails, dto);
    }

    @GetMapping("/list")
    @Operation(summary = "상품 조회")
    public ResponseEntity<TotListResponseDto> list(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ){
        return itemDetailService.list(userDetails);
    }
}
