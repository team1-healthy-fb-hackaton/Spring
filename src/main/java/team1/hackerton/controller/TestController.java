package team1.hackerton.controller;


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
    public  String uploadRecord(
            @RequestPart(name = "file", required = true) MultipartFile file) throws IOException {

        testService.uploadS3(file);
            return "성공";

    }
}
