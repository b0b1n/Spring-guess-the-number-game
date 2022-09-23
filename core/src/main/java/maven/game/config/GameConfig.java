package maven.game.config;

import maven.game.GuessCount;
import maven.game.MaxNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {
    // == fields ==
    @Value("${game.maxNumber:20}")// Default value is 20 in case game.guessCount wasn't found
    private int maxNumber;
    @Value("${game.guessCount:5}") // Default value is 5 in case game.guessCount wasn't found
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
