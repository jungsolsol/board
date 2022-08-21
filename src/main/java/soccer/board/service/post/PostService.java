package soccer.board.service.post;

import org.springframework.stereotype.Service;
import soccer.board.controller.dto.post.PostRequestDto;
import soccer.board.controller.dto.post.PostResponseDto;

import java.util.List;

public interface PostService {

    Integer viewMethod(Integer view);

    public void savePost(PostRequestDto postRequestDto);

    public List<PostRequestDto> getPostList();

    public PostRequestDto getPostById(Long id);

    public List<PostRequestDto> getPostByAuthor(String author);

    public void deletePost(Long id);

    public List<PostRequestDto> searchPost(String title);

    public void update(Long id, PostRequestDto postRequestDto);

}
