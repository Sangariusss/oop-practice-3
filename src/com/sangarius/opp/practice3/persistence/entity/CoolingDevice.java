package com.sangarius.opp.practice3.persistence.entity;

import com.sangarius.opp.practice3.domain.Component;
import com.sangarius.opp.practice3.domain.ConnectToCase;
import com.sangarius.opp.practice3.persistence.entity.enums.Brand;

public class CoolingDevice implements Component, ConnectToCase {

    private final String name;
    private final boolean liquidCooling;
    private final double price;
    private final Brand brand;

    public CoolingDevice(String name, boolean liquidCooling, double price, Brand brand) {
        this.name = name;
        this.liquidCooling = liquidCooling;
        this.price = price;
        this.brand = brand;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        String coolingType = liquidCooling ? "рідинне охолодження" : "повітряне охолодження";
        return "Система охолодження " + name + " (" + coolingType + ") від " + brand;
    }

    @Override
    public void connectToCase(Case computerCase) {
        computerCase.addComponent(this);
    }
}
