package consumer;

public class WarnConsumer {
    public static void main(String[] args) {
        LogsConsumer consumer = new LogsConsumer("warn");
        consumer.run("warn_pn");
    }
}
