package soccer.board.repository.Post;

import soccer.board.domain.Post;

import java.util.List;
import java.util.Optional;

public interface CustomPostRepository<Post,  Long> {


    public List<soccer.board.domain.Post> findByAuthor(String author);

    public List<soccer.board.domain.Post> findByTitleContaining(String title);
}
