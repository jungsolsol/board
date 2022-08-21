package soccer.board.repository.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import soccer.board.domain.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> , CustomPostRepository<Post,Long> {


    @Query("select p from Post p where p.title like %:keyword%")
    public List<Post> findByTitleContaining(@Param("keyword") String keyword);

//    Page<Post> findAll(Pageable pageable);
}
