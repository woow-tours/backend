package com.woow.tours.adapter.repository.jpa.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Payment {

    private Long id;

    private PaymentFormEnum paymentForms;


}