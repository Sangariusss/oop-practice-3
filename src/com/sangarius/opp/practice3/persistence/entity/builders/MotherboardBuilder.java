package com.sangarius.opp.practice3.persistence.entity.builders;

import com.sangarius.opp.practice3.persistence.entity.Memory;
import com.sangarius.opp.practice3.persistence.entity.Motherboard;
import com.sangarius.opp.practice3.persistence.entity.Processor;
import com.sangarius.opp.practice3.persistence.entity.Ram;
import com.sangarius.opp.practice3.persistence.entity.enums.Brand;
import com.sangarius.opp.practice3.persistence.entity.enums.FormFactor;
import java.util.List;

public class MotherboardBuilder {

    private String name;
    private double price;
    private FormFactor formFactor;
    private boolean overclocking;
    private Brand brand;
    private Processor processor;
    private List<Ram> rams;
    private List<Memory> memories;

    public MotherboardBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MotherboardBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public MotherboardBuilder setFormFactor(FormFactor formFactor) {
        this.formFactor = formFactor;
        return this;
    }

    public MotherboardBuilder setOverclocking(boolean overclocking) {
        this.overclocking = overclocking;
        return this;
    }

    public MotherboardBuilder setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public MotherboardBuilder setProcessor(Processor processor) {
        this.processor = processor;
        return this;
    }

    public void setRams(List<Ram> rams) {
        this.rams = rams;
    }

    public void setMemories(List<Memory> memories) {
        this.memories = memories;
    }

    public Motherboard build() {
       /* if (name == null || formFactor == null || brand == null || processor == null ||
            coolingDevice == null || rams == null || memories == null) {
            throw new MissingRequiredFieldException(
                "Не вдалося створити Motherboard. Обов'язкові поля не встановлені.");
        }*/

        return new Motherboard(name, price, formFactor, overclocking, brand, processor,
            rams, memories);
    }
}
