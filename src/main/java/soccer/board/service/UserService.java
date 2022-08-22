package soccer.board.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soccer.board.domain.User;
import soccer.board.repository.User.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private void duplicateMemberValidation(User user) {
        User findByPhoneNumber = userRepository.findByPhoneNumber(user.getPhoneNumber());

        if (findByPhoneNumber != null) {
            throw new IllegalStateException("이미 존재하는 번호입니다");
        }
    }

    //C
    public Long joinUser(User user) {
        duplicateMemberValidation(user);
        userRepository.save(user);
        return user.getId();
    }
    //R


    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public List<User> findOne(String username) {
        List<User> findUser = userRepository.findByUsername(username);
        return findUser;
    }



    @Transactional
    public void delete(String username, String password) {
        Optional<User> byUsernameAndPassword = userRepository.findByUsernameAndPassword(username, password);
        if (byUsernameAndPassword.isPresent()) {
            userRepository.delete(byUsernameAndPassword.get());
        } else {
            throw new IllegalStateException("존재하지 않는 회원입니다");
        }
    }
}
