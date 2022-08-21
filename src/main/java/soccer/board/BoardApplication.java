package soccer.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import soccer.board.config.FileUploadProperties;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(
		{FileUploadProperties.class}
)
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

}
