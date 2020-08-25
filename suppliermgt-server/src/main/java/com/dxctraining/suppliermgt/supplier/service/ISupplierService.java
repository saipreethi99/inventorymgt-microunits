package com.dxctraining.suppliermgt.supplier.service;

import java.util.List;

import com.dxctraining.suppliermgt.supplier.entities.Supplier;

public interface ISupplierService {
	Supplier add(Supplier supplier);

	Supplier findSupplierById(int id);

	void remove(int id);

	List<Supplier> displayAllSuppliers();

	Supplier update(Supplier supplier);

	boolean authentication(int id, String password);

}