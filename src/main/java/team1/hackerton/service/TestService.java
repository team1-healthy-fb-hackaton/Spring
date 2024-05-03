package team1.hackerton.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import team1.hackerton.domain.Item;
import team1.hackerton.repository.ItemRepository;

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

    @Autowired
    private ItemRepository itemRepository;

    public void uploadS3(MultipartFile[] files) throws IOException {
        Item item = new Item();

        for(int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String originalFilename = file.getOriginalFilename();
            String newFileName = UUID.randomUUID() + "_" + originalFilename;

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());

            // S3에 파일 업로드
            amazonS3Client.putObject(bucket, newFileName, file.getInputStream(), metadata);

            // 파일 유형에 따라 Item 속성에 저장
            if (i == 0) {
                item.setUrl(newFileName);
            } else if (i == 1) {
                item.setInfoUrl(newFileName);
            } else if (i == 2) {
                item.setNutritionUrl(newFileName);
            }
        }
        itemRepository.save(item);



    }
}
