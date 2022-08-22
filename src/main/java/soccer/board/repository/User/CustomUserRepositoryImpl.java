package soccer.board.repository.User;

import lombok.RequiredArgsConstructor;
import soccer.board.domain.User;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository{

    private final EntityManager em;
    @Override
    public User forConfigurationFindByUsername(String name) {
        return (User) em.createQuery("select u from User u where u.username = :name").setParameter("name", name).getSingleResult();
    }

}
