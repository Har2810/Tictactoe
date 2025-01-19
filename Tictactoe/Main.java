import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.print("Enter the board size (e.g., 3 for 3x3): ");
        int size = scanner.nextInt();
        scanner.nextLine();
        
        Game game = new Game(size);
        game.addObserver(new ConsoleDisplay());

        
        System.out.print("Enter the number of players (1 to " + (size - 1) + "): ");
        int totalPlayers = scanner.nextInt();
        scanner.nextLine(); 
        //int humansAdded = 0;

        // Add players
        for (int i = 1; i <= totalPlayers; i++) {
            System.out.print("Enter type for Player " + i + " (human/bot): ");
            String type = scanner.nextLine().trim();

            // if (response.equals("yes")) {
                System.out.print("Enter name for Player " + i + ": ");
                String name = scanner.nextLine();
                //scanner.nextLine();
                char symbol = (char) ('A' + i - 1);

                game.addPlayer(PlayerFactory.createPlayer(type, name, symbol));
                //humansAdded++;
            // } else {
            //     char symbol = (char) ('X' + humansAdded);
            //     game.addPlayer(new Player("Bot" + i, symbol, true));
            //     humansAdded++;
            // }
        }

        game.start();
    }
}
