package soccer.board.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "postId")
    private Long id;

    private String title;

    @Column(columnDefinition = "text")
    private String contents;

    private String author;

    private Integer view;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Builder
    public Post(String title, String contents, String author, Integer view) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.view = view;
    }


    //연관관계 메서드

    /**
     업데이트
     */
    public void updatePost(String title, String contents, String author, Integer view) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.view = view;
    }

    /**
     조회수 증가
     */
    public void increaseViewCount() {
        this.view++;
    }

}
