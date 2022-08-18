package soccer.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import soccer.board.repository.UserRepository;
import soccer.board.service.UserService;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping
    public String home() {
        return "helloWorld";
    }
}
