public class BotPlayer extends Player {
    public BotPlayer(String name, char symbol, MoveStrategy moveStrategy) {
        super(name, symbol, true, moveStrategy);
    }



    // @Override
    // public int makeMove(Board board) {
    //     // The bot chooses a random cell
    //     Random random = new Random();
    //     int cell;
    //     do {
    //         cell = random.nextInt(board.getSize() * board.getSize()) + 1;
    //     } while (!board.isCellEmpty(cell));
    //     System.out.println(getName() + " (Bot) chooses cell " + cell);
    //     return cell;
    // }
}
