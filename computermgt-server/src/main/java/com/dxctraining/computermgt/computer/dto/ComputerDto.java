package com.dxctraining.computermgt.computer.dto;

public class ComputerDto {
    private int id;
    private String name;
    private int diskSize;
    private int supplierId;
    private String supplierName;

    private ComputerDto(){

    }

    public ComputerDto(int id, String name, int diskSize){
        this.id = id;
        this.name = name;
        this.diskSize = diskSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
