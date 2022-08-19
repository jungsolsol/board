package soccer.board.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import soccer.board.domain.Gender;
import soccer.board.domain.MemberDetails;
import soccer.board.domain.Team;
import soccer.board.domain.User;

@Getter
@NoArgsConstructor
public class UserDetailDto {

    private String username;
    private Gender gender;
    private Team team;
    private MemberDetails memberDetails ;
    private String phoneNumber;
    private Integer age;
    private Integer level;


    public UserDetailDto(String username, Gender gender, Team team, MemberDetails memberDetails, String phoneNumber, Integer age, Integer level) {
        this.username = username;
        this.gender = gender;
        this.team = team;
        this.memberDetails = memberDetails;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.level = level;
    }

    public static UserDetailDto toDetailEntity(User user) {

        return new UserDetailDto(user.getUsername(), user.getGender(), user.getTeam(), user.getMemberDetails(), user.getPhoneNumber(),
                user.getAge(), user.getLevel());
    }
}
