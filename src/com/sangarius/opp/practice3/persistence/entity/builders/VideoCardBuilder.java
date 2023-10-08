package com.sangarius.opp.practice3.persistence.entity.builders;

import com.sangarius.opp.practice3.persistence.entity.VideoCard;
import com.sangarius.opp.practice3.persistence.entity.enums.Brand;
import com.sangarius.opp.practice3.persistence.entity.exceptions.MissingRequiredFieldException;

public class VideoCardBuilder {

    private String name;
    private Brand brand;
    private double price;

    public VideoCardBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public VideoCardBuilder setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public VideoCardBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public VideoCard build() {
        if (name == null || brand == null) {
            throw new MissingRequiredFieldException(
                "Не вдалося створити VideoCard. Обов'язкові поля не встановлені.");
        }

        return new VideoCard(name, brand, price);
    }
}
