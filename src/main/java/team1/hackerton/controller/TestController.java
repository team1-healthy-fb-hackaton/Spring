package team1.hackerton.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import team1.hackerton.service.TestService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping("/record")
    @Operation(summary = "이미지 AWS s3에 업로드")
    public String uploadRecord(@RequestPart(name = "files") MultipartFile[] files) throws IOException {
        testService.uploadS3(files);
        return "성공";
    }
}
