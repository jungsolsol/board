package soccer.board.controller.dto.post;

import lombok.*;
import soccer.board.domain.Post;

@NoArgsConstructor
@Data
public class PostResponseDto {

    private Long id;
    private String title;
    private String contents;
    private String author;
    private Integer view;


    @Builder
    public PostResponseDto(String title, String contents, String author, Integer view) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.view = view;
    }
}
