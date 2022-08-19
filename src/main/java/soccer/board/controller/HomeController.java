package soccer.board.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soccer.board.domain.User;
import soccer.board.repository.UserRepository;
import soccer.board.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;
    private final UserRepository userRepository;


    @GetMapping
    public String home() {
        return "helloWorld";
    }

    //r
    @GetMapping("/users")
    public ResponseEntity<List<UsersDto>> user() {
        List<User> all = userService.findUsers();
        List<UsersDto> collect = all.stream().map(UsersDto::toEntity).collect(Collectors.toList());
        return ResponseEntity.ok().body(collect);
    }

    @GetMapping("/users/userdetail")
    public ResponseEntity<List<UserDetailDto>> userDetailsFindByUsername(@RequestParam("username") String username) {
        List<User> byUsername = userService.findOne(username);
        List<UserDetailDto> collect = byUsername.stream().map(UserDetailDto::toDetailEntity).collect(Collectors.toList());
        return ResponseEntity.ok().body(collect);
    }


    //u
    @PutMapping("/users/{username}/update")
    public ResponseEntity<Long> userDetailsFindByUsernameUpdate(@PathVariable("username") String username,
    @RequestParam("password") String password) {
        return ResponseEntity.ok().body(userService.update(username,password));
    }
}
