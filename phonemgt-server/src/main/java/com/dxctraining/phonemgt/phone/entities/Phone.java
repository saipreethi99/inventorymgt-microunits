package com.dxctraining.phonemgt.phone.entities;

import javax.persistence.*;

@Entity
@Table(name = "phones")
public class Phone {
	@Id
	@GeneratedValue
	private int id;

	private int storageSize;

	private String name;

	private int supplierId;

	public Phone(String name, int supplierId, int storageSize) {
		this.name = name;
		this.supplierId = supplierId;
		this.storageSize = storageSize;

	}

	public Phone() {

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

	public int getStorageSize() {
		return storageSize;
	}

	public void setStoragesize(int storageSize) {
		this.storageSize = storageSize;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	@Override
	public boolean equals(Object arg) {
		if (this == arg) {
			return true;
		}

		if (arg == null || !(arg instanceof Phone)) {
			return false;
		}

		Phone that = (Phone) arg;
		boolean isequal = this.getClass() == that.getClass();
		return isequal;
	}

	@Override
	public int hashCode() {
		return id;
	}

}
