package consumer;

public class ErrorConsumer {
    public static void main(String[] args) {
        LogsConsumer consumer = new LogsConsumer("error");
        consumer.run("error_pn");
    }
}
