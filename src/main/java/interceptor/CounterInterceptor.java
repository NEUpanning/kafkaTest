package interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class CounterInterceptor implements ProducerInterceptor {
    int success = 0;
    int error = 0;
    @Override
    public ProducerRecord onSend(ProducerRecord producerRecord) {
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        if(recordMetadata == null)
            error++;
        else
            success++;
    }

    @Override
    public void close() {
        System.out.println("success："+success);
        System.out.println("error："+error);
    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
