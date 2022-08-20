package soccer.board.domain;

import lombok.*;
import soccer.board.audit.BaseTimeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Setter
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
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(nullable = false, length = 30)
    private String password;
    private String phoneNumber;

    private Integer age;

    @OneToMany(mappedBy = "user")
    private List<Post> post = new ArrayList<>();

    @Embedded
    private MemberDetails memberDetails ;
    private Boolean haveTeam;
    private Boolean isDeleted;

}
