package soccer.board.service.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soccer.board.controller.dto.post.PostRequestDto;
import soccer.board.controller.dto.post.PostResponseDto;
import soccer.board.domain.Post;
import soccer.board.repository.Post.PostRepository;
import soccer.board.repository.User.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public Integer viewMethod(Integer view) {
        return null;
    }

    @Transactional(readOnly = false)
    @Override
    public void savePost(PostRequestDto postRequestDto) {
        postRepository.save(postRequestDto.toEntity());
    }

    @Override
    public List<PostRequestDto> getPostList() {
        List<Post> findall = postRepository.findAll();
        List<PostRequestDto> postRequestDtos = new ArrayList<>();
        for (Post post : findall) {
            PostRequestDto postRequestDto = PostRequestDto.builder().
            title(post.getTitle()).author(post.getAuthor()).view(post.getView()).contents(post.getContents()).build();
            postRequestDtos.add(postRequestDto);
        }
        return postRequestDtos;
    }

    @Override
    public PostRequestDto getPostById(Long id) {
        Optional<Post> byId = postRepository.findById(id);
        Post post = byId.get();
        return PostRequestDto.builder().title(post.getTitle())
                .author(post.getAuthor()).contents(post.getContents()).view(post.getView()).build();
    }

    @Override
    public List<PostRequestDto> getPostByAuthor(String author) {
        List<Post> findAllbyAuthor = postRepository.findByAuthor(author);
        List<PostRequestDto> request = new ArrayList<>();
        for (Post post : findAllbyAuthor) {
            PostRequestDto postRequestDto = PostRequestDto.builder().
                    title(post.getTitle()).author(post.getAuthor()).view(post.getView()).contents(post.getContents()).build();
            request.add(postRequestDto);
        }
        return request;
    }

    @Transactional
    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);

    }

    @Override
    public List<PostResponseDto> searchPost(String title) {
        postRepository.findByTitleContaining(title);
        return null;

    }

    @Override
    public void update(Long id, PostRequestDto postRequestDto) {

    }
}
