package com.woow.tours.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CreditCard {

    private Long id;

    private String number;

    private String cardUserName;

    private LocalDate expirationDate;

    private String securityCode;
}
