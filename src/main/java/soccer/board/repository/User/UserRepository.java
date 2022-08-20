package soccer.board.repository.User;

import org.springframework.data.jpa.repository.JpaRepository;
import soccer.board.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByUsername(String name);

    public Optional<User> findByUsernameAndPassword(String username, String password);


}
