package com.sangarius.opp.practice3.persistence.entity.builders;

import com.sangarius.opp.practice3.persistence.entity.Ram;
import com.sangarius.opp.practice3.persistence.entity.enums.Brand;
import com.sangarius.opp.practice3.persistence.entity.exceptions.MissingRequiredFieldException;

public class RamBuilder {

    private String name;
    private Brand brand;
    private int capacityGB;
    private String type;
    private double price;

    public RamBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public RamBuilder setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public RamBuilder setCapacityGB(int capacityGB) {
        this.capacityGB = capacityGB;
        return this;
    }

    public RamBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public RamBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Ram build() {
        if (name == null || capacityGB <= 0 || type == null) {
            throw new MissingRequiredFieldException(
                "Не вдалося створити Ram. Обов'язкові поля не встановлені.");
        }

        return new Ram(name, capacityGB, brand, type, price);
    }
}
