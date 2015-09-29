/*
 * Copyright (c) 2015 TopCoder, Inc. All rights reserved.
 */
package com.hp.inventory.audit.rest.service.core;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Tablet Domain model which represents a tablet
 *
 * @author TCSCODER
 * @version 1.0
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tablet extends AbstractProduct {
    private String operatingSystem;

    private String processor;

    private String display;

    private String memory;

    private String internalStorage;

    private String wireless;

    private String battery;

    private String batteryLife;

    private Long maxBatteryLifeInHours;

    private String ports;

    private String expansionSlots;

    private String audio;

    private String sensors;

    private String color;

    private String integratedCamera;

    private String dimensions;

    private Long dimensionWidthInInches;

    private Long dimensionDepthInInches;

    private Long dimensionHeightInInches;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productNumber")
    private Collection<RelatedAccessory> topAccessories;

    private String weight;

    private Long weightInPounds;

    private String warranty;

    private String whatsInTheBox;

    private String softwareIncluded;

    private String modelNumber;

    private String chipset;
    private String energyEfficiency;
    private String graphics;
    private String internalDrive;
    private String powerSupply;
    private String processorFamily;
    private String processorTechnology;
    private String securityManagement;

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getEnergyEfficiency() {
        return energyEfficiency;
    }

    public void setEnergyEfficiency(String energyEfficiency) {
        this.energyEfficiency = energyEfficiency;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public String getInternalDrive() {
        return internalDrive;
    }

    public void setInternalDrive(String internalDrive) {
        this.internalDrive = internalDrive;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public String getProcessorFamily() {
        return processorFamily;
    }

    public void setProcessorFamily(String processorFamily) {
        this.processorFamily = processorFamily;
    }

    public String getProcessorTechnology() {
        return processorTechnology;
    }

    public void setProcessorTechnology(String processorTechnology) {
        this.processorTechnology = processorTechnology;
    }

    public String getSecurityManagement() {
        return securityManagement;
    }

    public void setSecurityManagement(String securityManagement) {
        this.securityManagement = securityManagement;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(String batteryLife) {
        this.batteryLife = batteryLife;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getDimensionDepthInInches() {
        return dimensionDepthInInches;
    }

    public void setDimensionDepthInInches(Long dimensionDepthInInches) {
        this.dimensionDepthInInches = dimensionDepthInInches;
    }

    public Long getDimensionHeightInInches() {
        return dimensionHeightInInches;
    }

    public void setDimensionHeightInInches(Long dimensionHeightInInches) {
        this.dimensionHeightInInches = dimensionHeightInInches;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Long getDimensionWidthInInches() {
        return dimensionWidthInInches;
    }

    public void setDimensionWidthInInches(Long dimensionWidthInInches) {
        this.dimensionWidthInInches = dimensionWidthInInches;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getExpansionSlots() {
        return expansionSlots;
    }

    public void setExpansionSlots(String expansionSlots) {
        this.expansionSlots = expansionSlots;
    }

    public String getIntegratedCamera() {
        return integratedCamera;
    }

    public void setIntegratedCamera(String integratedCamera) {
        this.integratedCamera = integratedCamera;
    }

    public String getInternalStorage() {
        return internalStorage;
    }

    public void setInternalStorage(String internalStorage) {
        this.internalStorage = internalStorage;
    }

    public Long getMaxBatteryLifeInHours() {
        return maxBatteryLifeInHours;
    }

    public void setMaxBatteryLifeInHours(Long maxBatteryLifeInHours) {
        this.maxBatteryLifeInHours = maxBatteryLifeInHours;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getPorts() {
        return ports;
    }

    public void setPorts(String ports) {
        this.ports = ports;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getSensors() {
        return sensors;
    }

    public void setSensors(String sensors) {
        this.sensors = sensors;
    }

    public String getSoftwareIncluded() {
        return softwareIncluded;
    }

    public void setSoftwareIncluded(String softwareIncluded) {
        this.softwareIncluded = softwareIncluded;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Long getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(Long weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public String getWhatsInTheBox() {
        return whatsInTheBox;
    }

    public void setWhatsInTheBox(String whatsInTheBox) {
        this.whatsInTheBox = whatsInTheBox;
    }

    public String getWireless() {
        return wireless;
    }

    public void setWireless(String wireless) {
        this.wireless = wireless;
    }

    public Collection<RelatedAccessory> getTopAccessories() {
        return topAccessories;
    }

    public void setTopAccessories(Collection<RelatedAccessory> topAccessories) {
        this.topAccessories = topAccessories;
    }
}
