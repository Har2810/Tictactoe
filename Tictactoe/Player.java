import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Player {
    private String name;
    private char symbol;
    private boolean isBot;
    private final MoveStrategy moveStrategy;

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    // Constructor
    public Player(String name, char symbol, boolean isBot, MoveStrategy moveStrategy) {
        this.name = name;
        this.symbol = symbol;
        this.isBot = isBot;
        this.moveStrategy = moveStrategy;
    }

    // Method to make a move
    // public int makeMove(ArrayList<Integer> availableCells) {
    //     if (isBot) {
    //         // Bot chooses a random cell from the available cells
    //         int randomIndex = random.nextInt(availableCells.size());
    //         int chosenCell = availableCells.get(randomIndex);
    //         System.out.println(name + " (Bot) chooses cell " + chosenCell);
    //         return chosenCell;
    //     } else {
    //         // Human player chooses a cell
    //         System.out.println(name + ", it's your turn. Enter a cell number: ");
    //         int chosenCell = scanner.nextInt();
    //         while (!availableCells.contains(chosenCell)) {
    //             System.out.println("Invalid cell. Please choose an available cell: ");
    //             chosenCell = scanner.nextInt();
    //         }
    //         return chosenCell;
    //     }
    // }

    // Getters
    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isBot() {
        return isBot;
    }
    // public abstract int makeMove(Board board);
    public int makeMove(Board board) {
        return moveStrategy.makeMove(board, name);
    }
}
