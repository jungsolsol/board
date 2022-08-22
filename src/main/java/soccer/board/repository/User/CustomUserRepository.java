package soccer.board.repository.User;

import soccer.board.domain.User;

public interface CustomUserRepository <User,Long> {
    public soccer.board.domain.User forConfigurationFindByUsername(String name);

 }
