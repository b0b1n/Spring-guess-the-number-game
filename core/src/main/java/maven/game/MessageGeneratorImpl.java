package maven.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    // == fields ==
    @Autowired
    private Game game;
    private int guessCount = 10;

    // == init ==
    @PostConstruct
    public void init() {
        log.info("game = {} .", game);
    }

    // == public method ==
    @Override
    public String getMainMessage() {
        return "number is between "
                + game.getSmallest()
                + " and " + game.getBiggest()
                + " . Can you guess it?";
    }

    @Override
    public String getResultMessage() {

        if(game.isGameWon()) {
            return " Congratulations!! You won ... The number you guessed was : " + game.getNumber();
        } else if (game.isGameLost()) {
            return "A A AAH!! You lost  :( ... The number  was : " + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "The number you guessed is out of range :(";
        } else if (game.getRemainingGuesses() == guessCount) {
            return " What will your first guess be? ";
        } else {
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            return direction + "!! You have : " + game.getRemainingGuesses() + " guesses left .";
        }
    }
}
