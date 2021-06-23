package com.woow.tours.adapter.repository.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentFormEnum {

    CREDIT("CREDIT", "Cartão de Crédito"),
    DEBIT("DEBIT", "Cartão de Débito"),
    BANK_SLIP("SLIP", "Boleto Bancário");

    private String code;

    private String description;

}
