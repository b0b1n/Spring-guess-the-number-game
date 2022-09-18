package maven.game.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    // == fields ==
    private int maxNumber = 50;
    private int guessCount;

    // == bean methods
    @Bean
    public int getMaxNumber() {
        return maxNumber;
    }
    @Bean
    public int getGuessCount() {
        return guessCount;
    }
}
