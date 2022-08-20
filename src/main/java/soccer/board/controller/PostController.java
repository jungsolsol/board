package soccer.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soccer.board.controller.dto.post.PostRequestDto;
import soccer.board.controller.dto.post.PostResponseDto;
import soccer.board.repository.Post.PostRepository;
import soccer.board.service.post.PostServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostServiceImpl postService;
    private final PostRepository postRepository;

    @PostMapping("/api/post")
    public PostResponseDto savePost(@RequestBody @Validated PostRequestDto postRequestDto) {
        postService.savePost(postRequestDto);
        return new PostResponseDto(postRequestDto.toEntity().getTitle(),
                postRequestDto.toEntity().getContents(),
                postRequestDto.toEntity().getAuthor(),
                postRequestDto.toEntity().getView());
    }

//    @PutMapping("/api/post/{id}")
//    public PostResponseDto updatePost(@PathVariable("id") Long id, @RequestBody, PostRequestDto postRequestDto) {
//        postService.update(id, postRequestDto);
//    }

    @GetMapping("/api/post/board")
    public List<PostRequestDto> getPostList() {
        List<PostRequestDto> postList = postService.getPostList();

        return postList;
    }

    @GetMapping("/api/post/{id}")
    public PostResponseDto getPostByFindById(@PathVariable("id") Long id) {
        PostRequestDto post = postService.getPostById(id);
        return new PostResponseDto(post.getTitle(), post.getContents(), post.getAuthor(), post.getView());
    }
    @GetMapping("/api/post/author/{author}")
    public List<PostResponseDto> getPostByFindByAuthor(@PathVariable("author") String author) {
        List<PostRequestDto> postByAuthor = postService.getPostByAuthor(author);
        List<PostResponseDto> postResponseDtos = new ArrayList<>();

        for (PostRequestDto postRequestDto : postByAuthor) {
            PostResponseDto postResponseDto = PostResponseDto.builder().author(postRequestDto.getAuthor())
                    .contents(postRequestDto.getContents()).title(postRequestDto.getTitle()).view(postRequestDto.getView()).build();
            postResponseDtos.add(postResponseDto);
        }
        return postResponseDtos;
    }


}
