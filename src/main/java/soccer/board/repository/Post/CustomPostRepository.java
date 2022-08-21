package soccer.board.repository.Post;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import soccer.board.domain.Post;

import java.util.List;
import java.util.Optional;

public interface CustomPostRepository<Post,  Long> {


    public List<soccer.board.domain.Post> findByAuthor(String author);

}
