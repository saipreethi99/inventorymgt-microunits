package com.dxctraining.suppliermgt.supplier.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.suppliermgt.supplier.exceptions.SupplierNotFoundException;
import com.dxctraining.suppliermgt.supplier.entities.Supplier;

@Repository
public class SupplierDaoImpl implements ISupplierDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Supplier findSupplierById(int id) {
		Supplier supplier = entityManager.find(Supplier.class, id);
		if (supplier == null) {
			throw new SupplierNotFoundException("supplier null");
		}
		return supplier;
	}

	@Override
	public void remove(int id) {
		Supplier supplier = findSupplierById(id);
		entityManager.remove(supplier);
	}

	@Override
	public void add(Supplier supplier) {
		entityManager.persist(supplier);

	}

	public List<Supplier> displayAllSuppliers() {
		String jpaql = "from Supplier";
		TypedQuery<Supplier> query = entityManager.createQuery(jpaql, Supplier.class);
		List<Supplier> supplierList = query.getResultList();
		return supplierList;
	}

	@Override
	public Supplier update(Supplier supplier) {
		entityManager.merge(supplier);
		return supplier;

	}

}