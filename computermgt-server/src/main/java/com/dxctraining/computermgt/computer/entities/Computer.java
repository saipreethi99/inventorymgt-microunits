package com.dxctraining.computermgt.computer.entities;

import javax.persistence.*;

@Entity
@Table(name = "computers")
public class Computer {

	@Id
	@GeneratedValue
	private int id;

	private int diskSize;

	private String name;
	
	private int supplierId;

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public Computer(String name,int supplierId, int diskSize) {
		this.name = name;
		this.supplierId=supplierId;
		this.diskSize = diskSize;
	}

	public Computer() {

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

	public void setDisksize(int diskSize) {
		this.diskSize = diskSize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object arg) {
		if (this == arg) {
			return true;
		}
		if (arg == null || (arg instanceof Computer)) {
			return false;
		}
		Computer that = (Computer) arg;
		boolean isequal = this.getId() == that.getId();
		return isequal;

	}

}