import java.util.Random;

public class RandomBotMoveStrategy implements MoveStrategy {

    @Override
    public int makeMove(Board board, String playerName) {
        Random random = new Random();
        int cell;
        do {
            cell = random.nextInt(board.getSize() * board.getSize()) + 1;
        } while (!board.isCellEmpty(cell));
        System.out.println(playerName + " (Bot) chooses cell " + cell);
        return cell;
    }
}
