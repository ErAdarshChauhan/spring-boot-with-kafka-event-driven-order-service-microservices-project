package net.javainzone.stockservice.kafka;

import net.javainzone.model.order.OrderEvent;
import net.javainzone.stockservice.repository.StockConsumerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockConsumer.class);
    @Autowired
    private StockConsumerRepository stockConsumerRepository;
    //consume topics

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeTopics(OrderEvent orderEvent) {
        LOGGER.info(String.format("order received -> %s", orderEvent));
        stockConsumerRepository.save(orderEvent);
    }
}
