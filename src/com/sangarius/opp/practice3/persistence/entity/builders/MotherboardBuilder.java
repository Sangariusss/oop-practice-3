package com.sangarius.opp.practice3.persistence.entity.builders;

import com.sangarius.opp.practice3.persistence.entity.CoolingDevice;
import com.sangarius.opp.practice3.persistence.entity.Memory;
import com.sangarius.opp.practice3.persistence.entity.Motherboard;
import com.sangarius.opp.practice3.persistence.entity.Processor;
import com.sangarius.opp.practice3.persistence.entity.Ram;
import com.sangarius.opp.practice3.persistence.entity.enums.Brand;
import com.sangarius.opp.practice3.persistence.entity.enums.FormFactor;
import com.sangarius.opp.practice3.persistence.entity.exceptions.MissingRequiredFieldException;
import java.util.List;

public class MotherboardBuilder {

    private String name;
    private FormFactor formFactor;
    private boolean overclocking;
    private Brand brand;
    private Processor processor;
    private CoolingDevice coolingDevice;
    private List<Ram> rams;
    private List<Memory> memories;

    public MotherboardBuilder setName(String name) {
        this.name = name;
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

    public MotherboardBuilder setCoolingDevice(CoolingDevice coolingDevice) {
        this.coolingDevice = coolingDevice;
        return this;
    }

    public MotherboardBuilder setRams(List<Ram> rams) {
        this.rams = rams;
        return this;
    }

    public MotherboardBuilder setMemories(List<Memory> memories) {
        this.memories = memories;
        return this;
    }

    public Motherboard build() {
        if (name == null || formFactor == null || brand == null || processor == null ||
            coolingDevice == null || rams == null || memories == null) {
            throw new MissingRequiredFieldException(
                "Не вдалося створити Motherboard. Обов'язкові поля не встановлені.");
        }

        return new Motherboard(name, formFactor, overclocking, brand, processor, coolingDevice,
            rams, memories);
    }
}
