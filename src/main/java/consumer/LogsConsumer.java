package consumer;

import org.apache.kafka.clients.consumer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class LogsConsumer {
    Properties properties = new Properties();
    public LogsConsumer(String group){
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.16.29.93:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 1000);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, group);
        //重置消费者offset
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
    }

    public void run(String topic){
        Consumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList(topic));
        System.out.println(properties.getProperty(ConsumerConfig.GROUP_ID_CONFIG));
        //拉取数据
        while(true){
            ConsumerRecords<String, String> reds = consumer.poll(100);
            for(ConsumerRecord c : reds){
                System.out.println(c.key()+"---"+c.value());
            }
        }
    }

    public static void main(String[] args) {
        LogsConsumer logsConsumer = new LogsConsumer("info1");
        logsConsumer.run("error_pn");
    }
}
