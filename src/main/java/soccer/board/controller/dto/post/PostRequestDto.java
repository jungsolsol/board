package soccer.board.controller.dto.post;

import lombok.*;
import soccer.board.domain.Post;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto {

    private Long id;
    private String title;
    private String contents;
    private String author;
    private Integer view;
//
//    public PostRequestDto() {
//
//    }
    @Builder

    public PostRequestDto(String title, String contents, String author, Integer view) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.view = view;
    }



    public Post toEntity() {
        return Post.builder().
                title(this.title).contents(this.contents).author(this.author).view(this.view).build();
    }
}
