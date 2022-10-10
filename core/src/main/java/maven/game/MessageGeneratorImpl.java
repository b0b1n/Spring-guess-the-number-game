package maven.game;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@AllArgsConstructor
@Component
public class MessageGeneratorImpl implements MessageGenerator {
    // == constants ==
    private static final String MAIN_MESSAGE = "game.main.message";
    // == fields ==
    private final Game game;
    private final MessageSource messageSource;


    // == constructor ==
    // == init ==
    @PostConstruct
    public void init() {
        log.info("game = {} .", game);
    }

    // == public method ==
    @Override
    public String getMainMessage() {
        return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getBiggest());
    }

    @Override
    public String getResultMessage() {

        if (game.isGameWon()) {
            return " Congratulations!! You won ... The number you guessed was : " + game.getNumber();
        } else if (game.isGameLost()) {
            return "A A AAH!! You lost  :( ... The number  was : " + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "The number you guessed is out of range :(";
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "number is between "
                    + game.getSmallest()
                    + " and " + game.getBiggest()
                    + " . Can you guess it? What will your first guess be? ";
        } else {
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            return direction + "!! You have : " + game.getRemainingGuesses() + " guesses left .";
        }
    }

    private String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
