package soccer.board.domain;

import soccer.board.audit.BaseTimeEntity;

import javax.persistence.*;

@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "boardId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
