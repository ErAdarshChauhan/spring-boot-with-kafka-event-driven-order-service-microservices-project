package net.javainzone.stockservice.repository;

import net.javainzone.model.order.OrderEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockConsumerRepository extends MongoRepository<OrderEvent,Integer> {

}
