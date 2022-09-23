package maven.game.config;

import maven.game.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "maven.game")
public class AppConfig {
    // == bean methods ==

    @Bean
    public MessageGenerator messageGenerator(){
        return new MessageGeneratorImpl();
    }

    @Bean
    public Game game(){
        return new GameImpl();
    }
}
