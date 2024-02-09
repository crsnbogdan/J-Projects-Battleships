package ComplexGame;

import gameuser.GameUser;
import java.util.Random;
import java.util.Scanner;

public class ComplexGame {
    private static final Scanner scanner = new Scanner(System.in);
    private static GameUser gameUser = new GameUser();
    private static final int serpentLengths[] = {3, 4, 5};
    private static boolean gameOver = false;
    private static int gameTurnsCtr = 0;
    private static final int OCEAN_SIZE = 9;
    private static ComplexGameSerpent[] complexGameSerpents = new ComplexGameSerpent[3];
    private static int killedSerpents = 0;

    public static void runGame () {
        gameUser.initializeUser();
        initializeSerpents();
        while (!gameOver) {
            initializeGameLoop();
        }
        endGame();
    }

    private static void initializeSerpents() {
        for (int i = 0; i < serpentLengths.length; i++) {
            complexGameSerpents[i] = new ComplexGameSerpent();
        }

        int serpentLengthIndex = 0;
        int[] serpentRows = new int[3];
        for (int i = 0; i < serpentRows.length; i++) {
            serpentRows[i] = -1;
        }

        for (ComplexGameSerpent serpent : complexGameSerpents) {
            serpent.setSerpentLength(serpentLengths[serpentLengthIndex]);
            serpentLengthIndex += 1;

            boolean rowFound = false;
            int rowPos = 0;
            while (!rowFound) {
                rowPos = new Random().nextInt(OCEAN_SIZE);
                boolean isRowUnique = true;
                for (int i = 0; i < serpentRows.length; i++) {
                    if (serpentRows[i] == rowPos) {
                        isRowUnique = false;
                        break;
                    }
                }
                if (isRowUnique) {
                    rowFound = true;
                    serpentRows[serpentLengthIndex - 1] = rowPos;
                }
            }

            serpent.initializeSerpentPositions();
            int serpentLength = serpent.getSerpentLength();
            int maxPossibleEndCol = OCEAN_SIZE - serpentLength;
            int startColPos = new Random().nextInt(maxPossibleEndCol + 1);
            int endColPos = startColPos + serpentLength - 1;

            serpent.setSerpentPosition(rowPos, startColPos, endColPos);
        }
    }

    private static void initializeGameLoop() {
        int[] userInput = validateInput(0, OCEAN_SIZE - 1);
        gameTurnsCtr++;
        System.out.println("Row: " + userInput[0] + ", Column: " + userInput[1]);

        int userInputRow = userInput[0];
        int userInputCol = userInput[1];

        boolean hit = false;

        for (ComplexGameSerpent serpent : complexGameSerpents) {
            if (serpent.getSerpentRow() == userInputRow) {
                int startCol = serpent.getStartCol();
                int endCol = serpent.getEndCol();

                if (userInputCol >= startCol && userInputCol <= endCol) {
                    serpent.hitSerpent(userInputCol - startCol);
                    hit = true;

                    if (serpent.checkSerpentSunkStatus()) {
                        killedSerpents += 1;
                        System.out.println("A sea serpent has been sunk!");
                    } else {
                        System.out.println("You've struck the sea serpent!");

                    }
                    break;
                }
            }
        }

        if (!hit) {
            System.out.println("Missed. No serpents were hit this turn.");
        }

        if (killedSerpents == complexGameSerpents.length) {
            gameOver = true;
        }

    }


    private static void endGame() {
        System.out.println("Congratulations, " + gameUser.getName() + ". You have vanquished the ancient sea serpent in " + gameTurnsCtr + " turns.");
        System.out.println("The oceans are once again safe, thanks to your valor.");
        scanner.close();
    }

    private static int[] validateInput(int min, int max) {
        while (true) {
            System.out.println("Enter two space-separated numbers between " + min + " and " + max + " to hit a location in the vast ocean:");
            String userInput = scanner.nextLine().trim();
            String[] inputStrArr = userInput.split("\\s* \\s*");

            if (inputStrArr.length != 2) {
                System.out.println("Invalid input. Please enter exactly two numbers separated by a space.");
                continue;
            }

            int[] inputIntArr = new int[2];
            boolean isValid = true;

            for (int i = 0; i < inputStrArr.length; i++) {
                try {
                    int number = Integer.parseInt(inputStrArr[i]);
                    if (number < min || number > max) {
                        System.out.println("Invalid input. Each number must be between " + min + " and " + max + ".");
                        isValid = false;
                        break;
                    }
                    inputIntArr[i] = number;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter numbers only.");
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                return inputIntArr;
            }
        }
    }


}

