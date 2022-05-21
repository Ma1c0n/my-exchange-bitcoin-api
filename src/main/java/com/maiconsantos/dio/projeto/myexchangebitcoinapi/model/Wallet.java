package com.maiconsantos.dio.projeto.myexchangebitcoinapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "Wallet")
@NoArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id = 1L;
    private String name;
    private Double moneyBalance;
    private Double moneyBitcoin;

    public Wallet(String name, Double moneyBalance, Double moneyBitcoin) {
        this.name = name;
        this.moneyBalance = moneyBalance;
        this.moneyBitcoin = moneyBitcoin;
    }
}
