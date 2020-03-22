package consumer;

import org.apache.kafka.clients.consumer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class MyConsumer  {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.16.29.92:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 1000);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "pn2");
        //重置消费者offset
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        Consumer<String, String> consumer = new KafkaConsumer<>(properties);

        ArrayList<String> a = new ArrayList<>();
        a.add("first");
       // a.add("test1");
        //订阅主题
        //consumer.subscribe(Arrays.asList("test1"));
        consumer.subscribe(a);
        //拉取数据
        while(true){
            ConsumerRecords<String, String> reds = consumer.poll(100);
            for(ConsumerRecord c : reds){
                System.out.println(c.key()+"---"+c.value());
            }
        }

    }
}
