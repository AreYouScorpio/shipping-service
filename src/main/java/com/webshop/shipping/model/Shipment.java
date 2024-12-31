package com.webshop.shipping.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Shipment {

    private String orderId;
    private String shippingAddress;
    private String status;
}