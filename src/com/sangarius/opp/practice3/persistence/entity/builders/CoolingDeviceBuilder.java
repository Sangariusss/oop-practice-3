package com.sangarius.opp.practice3.persistence.entity.builders;

import com.sangarius.opp.practice3.persistence.entity.CoolingDevice;
import com.sangarius.opp.practice3.persistence.entity.enums.Brand;
import com.sangarius.opp.practice3.persistence.entity.exceptions.MissingRequiredFieldException;

public class CoolingDeviceBuilder {

    private String name;
    private boolean liquidCooling;
    private double price;
    private Brand brand;

    public CoolingDeviceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CoolingDeviceBuilder setLiquidCooling(boolean liquidCooling) {
        this.liquidCooling = liquidCooling;
        return this;
    }

    public CoolingDeviceBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public CoolingDeviceBuilder setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public CoolingDevice build() {
        if (name == null) {
            throw new MissingRequiredFieldException(
                "Не вдалося створити CoolingDevice. Обов'язкові поля не встановлені.");
        }

        return new CoolingDevice(name, liquidCooling, price, brand);
    }
}
