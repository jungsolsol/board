package soccer.board.domain;

import lombok.NoArgsConstructor;
import soccer.board.audit.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "teamCode")
    private Long id;

    public Team() {
    }

    @OneToMany(mappedBy = "team" ,cascade = CascadeType.ALL)
    private List<User> user = new ArrayList<>();

    private String teamName;

    private LocalDateTime asOfDate;

    private Integer winningRate;
}