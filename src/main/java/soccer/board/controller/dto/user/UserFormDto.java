package soccer.board.controller.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
public class UserFormDto {


    @NotBlank(message = "이름은 필수입니다")
    private String name;// 실명

    @NotEmpty(message = "전화번호를 입력해주세요")
    private String phoneNumber; //전화번호
    private Integer age; //나이
    @NotEmpty(message = "아이디를 입력해주세요")
    private String username; //ID

    @NotEmpty(message = "비밀번호를 입력해주세요")
    @Length(min = 4, max = 16, message = "4~ 16자 사이로 입력해주세요")
    private String password; //PW

    @Builder
    public UserFormDto(String name, String phoneNumber, Integer age
            , String username, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.username = username;
        this.password = password;
    }
}
