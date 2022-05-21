package com.maiconsantos.dio.projeto.myexchangebitcoinapi.service.api.model;

import lombok.Getter;

@Getter
public class Ticker {
    private String high;
    private String low;
    private String vol;
    private String last;
    private String buy;
    private String sell;
    private String open;
    private Long date;
}
