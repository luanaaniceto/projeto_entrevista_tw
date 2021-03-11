package com.tw.hotel;

import java.math.BigDecimal;

public class Tarifario {
    
    private Hotel hotel;
    private BigDecimal tarifa;

    public Tarifario(Hotel hotel, BigDecimal tarifa) {
        this.hotel = hotel;
        this.tarifa = tarifa;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public BigDecimal getTarifa() {
        return tarifa;
    }

    public void setTarifa(BigDecimal tarifa) {
        this.tarifa = tarifa;
    }
}
