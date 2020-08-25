package com.dxctraining.suppliermgt.supplier.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String password;

	public Supplier(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public Supplier() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object arg) {
		if (this == arg) {
			return true;
		}

		if (arg == null || !(arg instanceof Supplier)) {
			return false;
		}

		Supplier that = (Supplier) arg;
		boolean isequal = this.id == that.id;
		return isequal;
	}

	@Override
	public int hashCode() {
		return id;
	}

}