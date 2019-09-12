import com.mooc.config.SwaggerConfig;
import com.mooc.server.MyGetMethod;
import com.mooc.server.MyPostMethod;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import({MyGetMethod.class, SwaggerConfig.class, MyPostMethod.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
