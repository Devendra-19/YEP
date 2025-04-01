package com.MLM.YEP.Services;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageProcessingService{
    final private String UPLOAD_DIR = "uploads/" ;
    public ImageProcessingService() throws IOException {
        Files.createDirectories(Paths.get(UPLOAD_DIR)) ;
    }
    public String generateURL(MultipartFile image, String name) throws IOException {
        String filename = image.getOriginalFilename() ;
        assert filename != null;
        String fileExtension = filename.substring(filename.lastIndexOf(".")) ;
        String productName = name.toLowerCase().replaceAll("\\s+","_") ;
        String newName = productName + fileExtension;
        Path path = Paths.get(UPLOAD_DIR + newName) ;
        Files.write(path , image.getBytes()) ;
        return "http://localhost:9090/api/products/images/" + newName;
    }
    //Store in Multiple Pixels
}
