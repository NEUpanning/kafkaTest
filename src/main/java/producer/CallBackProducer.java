package producer;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class CallBackProducer {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.16.29.92:9092");
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(prop);
        for(int i=0;i<10;i++){

            producer.send(new ProducerRecord<>("first", i%3+"","pan"+i), (recordMetadata, e) -> {
                if(e == null)
                    System.out.println(recordMetadata.partition()+"---"+recordMetadata.offset());
            });
        }
        producer.close();
    }
}
