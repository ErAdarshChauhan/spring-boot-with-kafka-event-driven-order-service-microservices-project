package net.javainzone.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Lob;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order_event")
public class OrderEvent {

    private String orderEventMessage;
    private String orderEventStatus;
    @Lob
    private Order order;
}
