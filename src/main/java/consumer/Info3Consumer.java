package consumer;

public class Info3Consumer {
    public static void main(String[] args) {
        LogsConsumer logsConsumer = new LogsConsumer("info3");
        logsConsumer.run("info_pn");
    }
}
