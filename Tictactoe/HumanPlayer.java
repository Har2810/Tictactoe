public class HumanPlayer extends Player {
    public HumanPlayer(String name, char symbol, MoveStrategy moveStrategy) {
        super(name, symbol, false, moveStrategy);
    }
}


    // @Override
    // public int makeMove(Board board) {
    //     // Let the human player choose the cell
    //     System.out.println(getName() + "'s turn. Enter a cell number:");
    //     return new java.util.Scanner(System.in).nextInt();
    // }

