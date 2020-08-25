package com.dxctraining.suppliermgt.supplier.dao;

import java.util.List;

import com.dxctraining.suppliermgt.supplier.entities.Supplier;

public interface ISupplierDao {
	void add(Supplier supplier);

	void remove(int id);

	Supplier findSupplierById(int id);

	List<Supplier> displayAllSuppliers();
	
	Supplier update(Supplier supplier);
}