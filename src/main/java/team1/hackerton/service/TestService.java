package team1.hackerton.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestService {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.s3.uploadPath}")
    private String defaultUrl;

    private final AmazonS3Client amazonS3Client;

    public void uploadS3(MultipartFile[] files) throws IOException {
        if(files != null && files.length > 0) {
            for(MultipartFile file : files) {
                String originalFilename = file.getOriginalFilename();
                String newfileName = UUID.randomUUID()+"_"+originalFilename;

                ObjectMetadata metadata = new ObjectMetadata();
                metadata.setContentLength(file.getSize());
                metadata.setContentType(file.getContentType());

                //S3에 저장
                amazonS3Client.putObject(bucket, newfileName, file.getInputStream(), metadata);
            }
        }
    }
}
