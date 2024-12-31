package com.webshop.shipping.listener;

import com.webshop.shipping.model.Shipment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ShipmentListener {

    @RabbitListener(queues = "shipmentQueue")
    public void processShipment(Shipment shipment) {
        System.out.println("Processing shipment for order: " + shipment.getOrderId());
        shipment.setStatus("Shipped");
    }
}
