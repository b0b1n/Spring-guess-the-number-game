package maven.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;


public class NumberGeneratorImpl implements NumberGenerator{

    // == Fields ==
    private final Random random = new Random();
    @Autowired
    private int maxNumber;

    // == Public methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
