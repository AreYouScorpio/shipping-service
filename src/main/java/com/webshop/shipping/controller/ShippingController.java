
import com.webshop.shipping.model.Shipment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/send")
    public String sendShipment(@RequestBody Shipment shipment) {
        rabbitTemplate.convertAndSend("shippingExchange", "shipment.routingKey", shipment);
        return "Shipment request sent for order: " + shipment.getOrderId();
    }
}