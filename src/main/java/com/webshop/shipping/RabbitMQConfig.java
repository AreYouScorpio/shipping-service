package com.webshop.shipping;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public DirectExchange shippingExchange() {
        return new DirectExchange("shippingExchange");
    }

    @Bean
    public Queue shipmentQueue() {
        return new Queue("shipmentQueue", true);
    }

    @Bean
    public Binding binding(Queue shipmentQueue, DirectExchange shippingExchange) {
        return BindingBuilder.bind(shipmentQueue).to(shippingExchange).with("shipment.routingKey");
    }
}
