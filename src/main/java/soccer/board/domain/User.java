package soccer.board.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import soccer.board.audit.BaseTimeEntity;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    private Integer level;

    public User() {
    }

    public User(String username, Gender gender, String password) {
        this.username = username;
        this.gender = gender;
        this.password = password;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamCode")
    private Team team;

    @Column(nullable = false, length = 15)
    private String username; //ID
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false, length = 30)
    private String password;
    private String phoneNumber;

    private Integer age;

    @Embedded
    private MemberDetails memberDetails;
    private Boolean haveTeam;
    private Boolean isDeleted;

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }

    public Team getTeam() {
        return team;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Boolean getHaveTeam() {
        return haveTeam;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
