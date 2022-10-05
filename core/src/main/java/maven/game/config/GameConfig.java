package maven.game.config;

import maven.game.GuessCount;
import maven.game.MaxNumber;
import maven.game.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "maven.game")
@PropertySource("classpath:config/game.properties")
public class GameConfig {
    // == fields ==
    @Value("${game.maxNumber:20}")// Default value is 20 in case game.guessCount wasn't found
    private int maxNumber;
    @Value("${game.guessCount:5}") // Default value is 5 in case game.guessCount wasn't found
    private int guessCount;

    @Value("${game.minNumber:5}")
    private int minNumber;


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

    @Bean
    @MinNumber
    public int getMinNumber() {
        return minNumber;
    }
}
