package com.pmdevelop.propertymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRecord {

    private Integer id;
    private Integer userId;
    private Float propertyFee;
    private Float parkingFee;
    private Date startTime;
    private Date endTime;
    private Boolean paymentStatus;
    private Date paymentTime;
    private Integer roomId;

    // Getters and Setters
}
