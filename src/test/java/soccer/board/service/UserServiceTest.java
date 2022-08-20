//package soccer.board.service;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//import soccer.board.domain.Gender;
//import soccer.board.domain.User;
//import soccer.board.repository.User.UserRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@SpringBootTest
//@Transactional
//public class UserServiceTest {
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Test
//    void joinUser() throws Exception {
////
////        User userA = new User("a", Gender.Male, "a");
////        User userB = new User("b", Gender.Female, "b");
////        Long id = userService.joinUser(userA);
////        Assertions.assertEquals(userA, userRepository.findById(id).orElse(userB));
////    }
////
////    @Test
////    void duplicatedMember()  {
////        User userA = new User("a", Gender.Male, "a");
////        User userB = new User("a", Gender.Male, "a");
////        userService.joinUser(userA);
////        try {
////            userService.joinUser(userB);
////        } catch (IllegalStateException e) {
////            return;
////        }
////        Assertions.fail("test fail");
////
////    }
////
////    @Test
////    void findOne() {
////        User userA = new User("a", Gender.Male, "a");
////        userService.joinUser(userA);
////        List<User> findUsers = userService.findOne("a");
////        Assertions.assertEquals(findUsers.get(0),userA);
////    }
////}