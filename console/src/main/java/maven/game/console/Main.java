package maven.game.console;

import lombok.extern.slf4j.Slf4j;
import maven.game.config.GameConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("\t\tGuess the number game");

        // create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

        //close context(context)
        context.close();

    }
}
