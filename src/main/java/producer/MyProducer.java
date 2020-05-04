package producer;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.*;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class MyProducer {
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
        //生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
//
//
        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<>("first","pi10mr,WT02287,2016/1/1 0:10,0,10.02,0,0,127.62,0,30.62,28.56,-3.11,2.19,22.25,0,0,0,0,0,0,0,0,-0.54,0.36,9815620,0,0,0,102,1,WT02287" ));
            System.out.println("lllll");
        }
        //producer.send(new ProducerRecord<>("first","WT02287","pi10mr,WT02287,2016/1/1 0:10,0,10.02,0,0,127.62,0,30.62,28.56,-3.11,2.19,22.25,0,0,0,0,0,0,0,0,-0.54,0.36,9815620,0,0,0,102,1,WT02287" ));
        producer.close();
    }
}
