package soccer.board.controller;

import lombok.*;
import org.springframework.stereotype.Component;
import soccer.board.domain.Gender;
import soccer.board.domain.Team;
import soccer.board.domain.User;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UsersDto {

    private String username;
    private Gender gender;
    private Team team;

    public UsersDto(String username, Gender gender,  Team team) {
        this.username = username;
        this.gender = gender;
        this.team = team;
    }

    public static UsersDto toEntity(User user) {
        return new UsersDto(user.getUsername(), user.getGender(),
                 user.getTeam());
    }


}
