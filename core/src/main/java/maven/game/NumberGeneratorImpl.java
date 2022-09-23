package maven.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;


public class NumberGeneratorImpl implements NumberGenerator{

    // == Fields ==
    private final Random random = new Random();
    @Autowired
    @MaxNumber
    private int maxNumber;
    @Autowired
    @MinNumber
    private int minNumber;

    // == Public methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber-minNumber)+minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }
}
