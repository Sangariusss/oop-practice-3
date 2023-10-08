package com.sangarius.opp.practice3.persistence.entity.builders;

import com.sangarius.opp.practice3.persistence.entity.AudioCard;
import com.sangarius.opp.practice3.persistence.entity.enums.Brand;
import com.sangarius.opp.practice3.persistence.entity.exceptions.MissingRequiredFieldException;

public class AudioCardBuilder {

    private String name;
    private Brand brand;
    private double price;

    public AudioCardBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AudioCardBuilder setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public AudioCardBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public AudioCard build() {
        if (name == null || brand == null) {
            throw new MissingRequiredFieldException(
                "Не вдалося створити AudioCard. Обов'язкові поля не встановлені.");
        }

        return new AudioCard(name, brand, price);
    }

}

