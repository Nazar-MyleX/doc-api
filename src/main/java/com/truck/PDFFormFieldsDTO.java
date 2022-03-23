package com.truck;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class PDFFormFieldsDTO {
    private String carrier;
    private String weight;
    private String pallets;
    private String shipper;
    private String shipperAddress;
    private String shipperPOPU;
    private String receiver;
    private String receiverAddress;
    private String receiverPOPU;
    private String amount;
    private String comments;
    private String cod;
    private String name;
    private String equipment;
    private String temperature;
    private String pickUpDate;
    private String pickUpTime;
    private String deliveryDate;
    private String deliveryTime;
}
