package soccer.board.repository.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soccer.board.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository<User,Long> {

    public List<User> findByUsername(String name);

    public User findByPhoneNumber(String phoneNumber);

    public Optional<User> findByUsernameAndPassword(String username, String password);


}
