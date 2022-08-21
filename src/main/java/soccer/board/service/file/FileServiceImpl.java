package soccer.board.service.file;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import soccer.board.config.FileUploadProperties;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@Transactional
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private Path path;


    @Autowired
    public void PostFileService(FileUploadProperties fileUploadProperties) {
        this.path = Paths.get(fileUploadProperties.getLocation()).toAbsolutePath().normalize();
    }

    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(this.path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String saveFile(MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename();
        Path location = this.path.resolve(originalFilename);
        try {
            Files.copy(multipartFile.getInputStream(), location, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return originalFilename;
    }

    public UrlResource loadFile(String originalFilename) throws FileNotFoundException {
        try {
            Path file = this.path.resolve(originalFilename).normalize();
            UrlResource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }else {
                throw new FileNotFoundException("Could not find file");
            }
        } catch (MalformedURLException e) {
            throw new FileNotFoundException("Could not download file");
        }
        }

}

