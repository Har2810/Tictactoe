public class ConsoleDisplay implements Observer {

    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
