package soccer.board.repository.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soccer.board.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> , CustomPostRepository<Post,Long> {

}
