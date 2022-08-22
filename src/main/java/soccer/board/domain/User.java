package soccer.board.domain;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import soccer.board.audit.BaseTimeEntity;
import soccer.board.controller.dto.user.UserFormDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    private Integer level;

    @OneToMany(mappedBy = "user")
    private List<Board> board = new ArrayList<>();
    public User() {
    }

    public User(Long id, Integer level, List<Board> board, Team team, String username, Gender gender, String password, String phoneNumber, Integer age, MemberDetails memberDetails, Boolean haveTeam, Boolean isDeleted) {
        this.id = id;
        this.level = level;
        this.board = board;
        this.team = team;
        this.username = username;
        this.gender = gender;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.memberDetails = memberDetails;
        this.haveTeam = haveTeam;
        this.isDeleted = isDeleted;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamCode")
    private Team team;

    @Column(nullable = false, length = 15)
    private String username; //ID

    @Column(nullable = false, length = 15)
    private String name;// 실명


    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(nullable = false, length = 30)
    private String password;
    private String phoneNumber;

    private Integer age;

    @OneToMany(mappedBy = "user")
    private List<Post> postList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Role role;
    @Embedded
    private MemberDetails memberDetails ;
    private Boolean haveTeam;
    private Boolean isDeleted;


    @Builder
    public User(String name, String username, String password, String phoneNumber, Integer age,Role role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.role = role;
    }


    //연관관계 메서드

    public String getRole() {
        this.role = role;
        return role.toString();
    }

    /**
     * 회원가입 양식
     */
    public static User createUser(UserFormDto userFormDto, PasswordEncoder passwordEncoder) {
        User user = User.builder().name(userFormDto.getName()).age(userFormDto.getAge()).phoneNumber(userFormDto.getPhoneNumber())
                .username(userFormDto.getUsername()).password(passwordEncoder.encode(userFormDto.getPassword())).build();

        return user;
    }
}
