package consumer;

public class Info2Consumer {
    public static void main(String[] args) {
        LogsConsumer logsConsumer = new LogsConsumer("info2");
        logsConsumer.run("info_pn");
    }
}
