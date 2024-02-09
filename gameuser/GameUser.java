package gameuser;
import java.util.Scanner;
public class GameUser {
    private static Scanner scanner = new Scanner(System.in);
    private String name = "";
    private static final int MAX_NAME_LENGTH = 15;

    public void setName(String userName) {
        this.name = userName;
    }

    public String getName() {
        return this.name;
    }

    public void initializeUser() {
        System.out.println("What is your name?");
        String userName = scanner.nextLine().trim();

        while (userName.isEmpty() || userName.length() > MAX_NAME_LENGTH) {
            if (userName.isEmpty()) {
                System.out.println("A name is required to be remembered in the annals of history:");
            } else {
                System.out.println("The scrolls cannot bear names longer than " + MAX_NAME_LENGTH +  " characters. Enter thy name again:");
            }
            userName = scanner.nextLine().trim();
        }

        setName(userName);
        System.out.println("Welcome, " + userName + ", to the hunt for the ancient sea serpent.");
    }
}
