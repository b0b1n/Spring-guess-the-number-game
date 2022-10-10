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
    private static final String GAME_WON = "game.won";
    private static final String GAME_LOST = "game.lost";
    private static final String INVALID_RANGE = "game.invalid.range";
    private static final String FIRST_GUESS = "game.first.guess";
    private static final String GUESSES_LEFT = "game.guessesLeft";
    private static final String HIGHER = "game.higher";
    private static final String LOWER = "game.lower";
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
            return getMessage(GAME_WON,game.getNumber());
        } else if (game.isGameLost()) {
            return getMessage(GAME_LOST, game.getNumber());
        } else if (!game.isValidNumberRange()) {
            return getMessage(INVALID_RANGE);
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return getMessage(FIRST_GUESS, game.getSmallest(), game.getBiggest());
        } else {
            String direction = getMessage(LOWER);
            if (game.getGuess() < game.getNumber()) {
                direction = getMessage(HIGHER);
            }
            return getMessage(GUESSES_LEFT, direction, game.getRemainingGuesses());
        }
    }

    private String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
