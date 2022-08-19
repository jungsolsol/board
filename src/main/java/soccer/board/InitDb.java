package soccer.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import soccer.board.domain.*;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();

    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {
            User userA = createUser("userA", "1234", Gender.Female);
            em.persist(userA);
//            User userB = createUser("userB", "1234", Gender.Female, new MemberDetails(MemberPosition.a, new Address("a", "b", "c"), Status.level1));
//            em.persist(userB);
//            User userC = createUser("userC", "1234", Gender.Female, new MemberDetails(MemberPosition.a, new Address("a", "b", "c"), Status.level1));
//            em.persist(userC);
//            User userD = createUser("userD", "1234", Gender.Female, new MemberDetails(MemberPosition.a, new Address("a", "b", "c"), Status.level1));
//            em.persist(userD);
//            User userE = createUser("userE", "1234", Gender.Male, new MemberDetails(MemberPosition.b, new Address("a", "b", "c"), Status.level1));
//            em.persist(userE);
        }

        private User createUser(String username, String password, Gender gender) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            return user;
        }
    }
}
