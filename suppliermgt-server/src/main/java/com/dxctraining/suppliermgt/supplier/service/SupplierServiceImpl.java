package com.dxctraining.suppliermgt.supplier.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dxctraining.suppliermgt.supplier.dao.ISupplierDao;
import com.dxctraining.suppliermgt.supplier.entities.Supplier;
import com.dxctraining.suppliermgt.supplier.exceptions.InvalidArgumentException;

@Transactional
@Service
public class SupplierServiceImpl implements ISupplierService {

	@Autowired
	private ISupplierDao dao;

	@Override
	public Supplier findSupplierById(int id) {
		Supplier supplier = dao.findSupplierById(id);
		return supplier;
	}

	@Override
	public void remove(int id) {
		dao.remove(id);
	}

	@Override
	public Supplier add(Supplier supplier) {
		validate(supplier);
		dao.add(supplier);
		return supplier;
	}

	public List<Supplier> displayAllSuppliers() {
		List<Supplier> suppliers = dao.displayAllSuppliers();
		return suppliers;
	}

	public void validate(Object arg) {
		if (arg == null) {
			throw new InvalidArgumentException("argument is null");
		}
	}

	@Override
	public Supplier update(Supplier supplier) {
		validate(supplier);
		dao.update(supplier);
		return supplier;
	}
	
	@Override
	public boolean authentication(int id, String password) {
		Supplier supplier = dao.findSupplierById(id);
		String fetchedpassword = supplier.getPassword();
		boolean equals = fetchedpassword.equals(password);
		return equals;
	}

}