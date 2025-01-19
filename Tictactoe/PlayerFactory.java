public class PlayerFactory {
    public static Player createPlayer(String type, String name, char symbol) {
        MoveStrategy moveStrategy;

        if (type.equalsIgnoreCase("human")) {
            moveStrategy = new HumanMoveStrategy(); // Create a HumanMoveStrategy for human players
        } else if (type.equalsIgnoreCase("bot")) {
            moveStrategy = new RandomBotMoveStrategy(); // Create a RandomBotMoveStrategy for bot players
        } else {
            throw new IllegalArgumentException("Invalid player type");
        }

        // Return the corresponding player type (either HumanPlayer or BotPlayer)
        if (type.equalsIgnoreCase("human")) {
            return new HumanPlayer(name, symbol, moveStrategy);
        } else {
            return new BotPlayer(name, symbol, moveStrategy);
        }
    }
}
