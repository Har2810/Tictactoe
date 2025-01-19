import java.util.*;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final List<Player> players;
    private final ArrayList<Integer> availableCells;
    private int currentPlayerIndex;
    private Scanner scanner;
    private List<Observer> observers;
    public Game(int size) {
        this.board = new Board(size);
        this.players = new ArrayList<>();
        this.availableCells = new ArrayList<>();
        this.observers = new ArrayList<>();
        for (int i = 1; i <= size * size; i++) {
            availableCells.add(i);
        }
        this.currentPlayerIndex = 0;
        scanner = new Scanner(System.in);
    }

    
public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
    public void start() {
        int currentPlayerIndex = 0;

        while (true) {
            board.displayBoard();
            Player currentPlayer = players.get(currentPlayerIndex);

            System.out.println(currentPlayer.getName() + "'s turn.");
            int cell;

            if (currentPlayer.isBot()) {
                // Bot makes a random move
                cell = getRandomMove();
                notifyObservers("Bot chose cell: " + cell);
            } else {
                // Human player makes a move
                System.out.print("Enter a cell number: ");
                cell = scanner.nextInt();
                notifyObservers(currentPlayer.getName() + " chose cell: " + cell);
            }

            if (!board.isValidMove(cell)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board.updateCell(cell, currentPlayer.getSymbol());

            if (board.isWinningMove(cell, currentPlayer.getSymbol())) {
                board.displayBoard();
                notifyObservers(currentPlayer.getName() + " wins!");
                break;
            }

            if (board.isFull()) {
                board.displayBoard();
                notifyObservers("It's a draw!");
                break;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    private int getRandomMove() {
        int size = board.getSize();
        int move;

        do {
            move = (int) (Math.random() * (size * size)) + 1;
        } while (!board.isValidMove(move));

        return move;
    }
    public void addPlayer(Player player) {
        players.add(player);
    }
}