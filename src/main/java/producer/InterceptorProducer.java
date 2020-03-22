package producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Arrays;
import java.util.Properties;

public class InterceptorProducer {
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();

        //kafka 集群，broker-list
        props.put("bootstrap.servers", "172.16.29.92:9092");
        props.put("acks", "all");
        //重试次数
            props.put("retries", 1);

        //批次大小
        props.put("batch.size", 16384);

        //等待时间
        props.put("linger.ms", 1);

        //RecordAccumulator 缓冲区大小
        props.put("buffer.memory", 33554432);

        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, Arrays.asList("interceptor.TimeInterceptor", "interceptor.CounterInterceptor"));
        //生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<>("first","panning"+i ));
            System.out.println("lllll");
        }

        producer.close();
    }
}
