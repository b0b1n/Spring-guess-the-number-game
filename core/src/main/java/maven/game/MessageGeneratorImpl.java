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
        return "calling method : getMainMessage()";
    }

    @Override
    public String getResultMessage() {
        return "calling method : getResultMessage()";
    }
}
