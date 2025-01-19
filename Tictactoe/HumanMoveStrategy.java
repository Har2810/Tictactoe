import java.util.Scanner;

public class HumanMoveStrategy implements MoveStrategy {

    @Override
    public int makeMove(Board board, String playerName) {
        System.out.println(playerName + "'s turn. Enter a cell number:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
