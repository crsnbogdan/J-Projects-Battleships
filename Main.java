import ComplexGame.ComplexGame;
import SimpleGame.SimpleGame;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeGame(scanner);
        boolean continuePlaying = true;
        while(continuePlaying) {
            continuePlaying = loopGame(scanner);
        }
        scanner.close();
    }

    private static void initializeGame(Scanner scanner) {
        System.out.println("Would you like to play a simple or a complex game (type \"simple\" or \"complex\" depending on your choice)? If this is your first time playing, choosing a simple game is recommended.");
        boolean gameTypeChosen = false;
        while(!gameTypeChosen) {
            String gameTypeChoice = scanner.nextLine().toLowerCase().trim();
            if(gameTypeChoice.equals("simple")) {
                gameTypeChosen = true;
                SimpleGame.runGame();
            } else if(gameTypeChoice.equals("complex")) {
                gameTypeChosen = true;
                ComplexGame.runGame();
            } else {
                System.out.println("Invalid input. Please type \"simple\" or \"complex\" depending on your choice.");
            }
        }
    }

    private static boolean loopGame(Scanner scanner) {
        System.out.println("Would you like to play again?");
        String playAgain = scanner.nextLine().toLowerCase().trim();
        if(playAgain.equals("yes")) {
            initializeGame(scanner);
            return true;
        } else if(playAgain.equals("no")) {
            System.out.println("Thank you for playing!");
            return false;
        } else {
            System.out.println("Invalid input. Please type \"yes\" or \"no\" depending on your choice.");
            return true;
        }
    }
}
