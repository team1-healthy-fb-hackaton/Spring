package team1.hackerton.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import team1.hackerton.domain.Member;
import team1.hackerton.dto.response.ItemDetailResponseDto;
import team1.hackerton.service.ItemDetailService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ItemController {

    private ItemDetailService itemDetailService;

    @Operation(summary = "상품디테일")
    @GetMapping("/item-detail/{itemId}")
    public ItemDetailResponseDto.ItemDetailDto readItemDetail(@AuthenticationPrincipal Member member, @PathVariable(name="itemId") Long itemId){

        return itemDetailService.readItemDetail(member, itemId);

    }
}
