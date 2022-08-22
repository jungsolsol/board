package soccer.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import soccer.board.service.file.FileService;
import soccer.board.service.post.PostService;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final PostController postController;
    private final PostService postService;

    private final FileService fileService;
    @PostMapping("/api/post/upload")
    public ResponseEntity<?> uploadFile(MultipartFile file) {
        String fileName = fileService.storeFile(file);

        if (file.isEmpty()) {
            return null;
        }

        String URI = ServletUriComponentsBuilder.fromCurrentContextPath().path("/desktop/").path(file.getName()).toUriString();
        System.out.println("URI = " + URI + "fileName = " + fileName);
        return new ResponseEntity<>(URI, HttpStatus.OK);
    }

    @GetMapping("/api/post/download/{fileName:.+}")
    public ResponseEntity<?> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws FileNotFoundException {

        UrlResource urlResource = fileService.loadFile(fileName);

        String contentType = null;

        try {
            contentType = request.getServletContext().getMimeType(urlResource.getFile().getAbsolutePath());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 기본 컨텐츠 유형

        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + urlResource.getFilename() + "\"")
                .body(urlResource);

    }
}
