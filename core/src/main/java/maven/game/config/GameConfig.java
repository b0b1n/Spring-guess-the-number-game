package maven.game.config;

import maven.game.GuessCount;
import maven.game.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    // == fields ==
    private int maxNumber = 50;
    private int guessCount = 8;

    // == bean methods
    @Bean
    @MaxNumber
    public int getMaxNumber() {
        return maxNumber;
    }
    @Bean
    @GuessCount
    public int getGuessCount() {
        return guessCount;
    }
}
