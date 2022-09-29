package maven.game.console;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maven.game.Game;
import maven.game.MessageGenerator;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@AllArgsConstructor
@Component
public class ConsoleNumberGuess {

    // == Fields ==
    public final Game game;

    private final MessageGenerator messageGenerator;

    // == events ==
    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info(" ==> start() --> Container ready to be used.");

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.print(messageGenerator.getResultMessage() + "\t");
            //Getting input from the user
            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            //check the user guess
            game.check();

            if(game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n?");

                String playAgainString = scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();
            }

        }
    }
}
