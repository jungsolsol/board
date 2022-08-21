package soccer.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import soccer.board.service.post.PostService;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final PostController postController;
    private final PostService postService;
}
