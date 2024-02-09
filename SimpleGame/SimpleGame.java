package SimpleGame;
import java.util.Scanner;
import java.util.Random;
import gameuser.GameUser;

public class SimpleGame {
    private static final Scanner scanner = new Scanner(System.in);
    private static GameUser gameUser;
    private static SimpleGameSerpent seaSerpent;
    private static int serpentStartIndex;
    private static int serpentLength;
    private static boolean gameOver;
    private static int gameTurnsCtr = 0;

    private static final int MAX_SERPENT_LENGTH = 3;
    private static final int OCEAN_SIZE = 9;
    private static final int MAX_START_INDEX = OCEAN_SIZE - MAX_SERPENT_LENGTH + 1;

    public static void runGame () {
        initializeGame();
        while (!gameOver) {
            gameLoop();
        }
        endGame();
    }

    private static void initializeGame() {
        System.out.println("The hunt begins... The ancient sea serpent awakens from its slumber.");
        gameUser = new GameUser();
        seaSerpent = new SimpleGameSerpent();
        serpentLength = MAX_SERPENT_LENGTH; // Assuming the sea serpent's length
        serpentStartIndex = new Random().nextInt(MAX_START_INDEX);
        gameOver = false;

        gameUser.initializeUser();
        seaSerpent.summonSerpent(serpentLength, serpentStartIndex);
    }

    private static void gameLoop() {
        System.out.println("Choose your target in the vast ocean (0-9):");
        int userInput = validateInput(0, OCEAN_SIZE);
        gameTurnsCtr++;

        if (seaSerpent.strikeSerpent(userInput)) {
            System.out.println("You've struck the sea serpent!");
            gameOver = seaSerpent.checkSerpent();
        } else {
            System.out.println("The serpent eludes your strike.");
        }
    }

    private static void endGame() {
        System.out.println("Congratulations, " + gameUser.getName() + ". You have vanquished the ancient sea serpent in " + gameTurnsCtr + " turns.");
        System.out.println("The oceans are once again safe, thanks to your valor.");
        scanner.close();
    }

    private static int validateInput(int min, int max) {
        while (true) {
            System.out.println("Enter a number between " + min + " and " + max + ":");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number:");
                scanner.next(); // Consume the non-integer input
            }

            int userInput = scanner.nextInt();
            if (userInput >= min && userInput <= max) {
                return userInput;
            } else {
                System.out.println("Invalid input. Please choose a position within the ocean's bounds.");
            }
        }
    }
}
