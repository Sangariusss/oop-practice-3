package com.sangarius.opp.practice3.persistence.entity.builders;

import com.sangarius.opp.practice3.persistence.entity.Memory;
import com.sangarius.opp.practice3.persistence.entity.enums.Brand;
import com.sangarius.opp.practice3.persistence.entity.exceptions.MissingRequiredFieldException;

public class MemoryBuilder {

    private String name;
    private int capacityGB;
    private String type;
    private Brand brand;
    private double price;

    public MemoryBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MemoryBuilder setCapacityGB(int capacityGB) {
        this.capacityGB = capacityGB;
        return this;
    }

    public MemoryBuilder setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public MemoryBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public MemoryBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Memory build() {
        if (name == null || capacityGB <= 0 || type == null) {
            throw new MissingRequiredFieldException(
                "Не вдалося створити Memory. Обов'язкові поля не встановлені.");
        }

        return new Memory(name, capacityGB, type, price, brand);
    }
}
