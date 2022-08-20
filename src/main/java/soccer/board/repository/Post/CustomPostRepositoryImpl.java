package soccer.board.repository.Post;

import lombok.RequiredArgsConstructor;
import soccer.board.domain.Post;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class CustomPostRepositoryImpl implements CustomPostRepository{

    private final EntityManager em;
    @Override
    public List<Post> findByAuthor(String author) {
        return em.createQuery("select p from Post p where p.author = :author").setParameter("author", author).getResultList();

    }

    @Override
    public List<Post> findByTitleContaining(String title) {
        return null;
    }
}
