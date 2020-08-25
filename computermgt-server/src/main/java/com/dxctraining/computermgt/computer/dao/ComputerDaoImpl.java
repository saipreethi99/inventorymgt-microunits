package com.dxctraining.computermgt.computer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.computermgt.computer.entities.Computer;

@Repository
public class ComputerDaoImpl implements IComputerDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Computer findComputerById(int id) {
		Computer computer = entityManager.find(Computer.class, id);
		return computer;
	}

	@Override
	public Computer add(Computer computer) {
		entityManager.persist(computer);
		return computer;
	}

	@Override
	public void remove(int id) {
		Computer computer = findComputerById(id);
		entityManager.remove(computer);
	}

	public List<Computer> allComputers() {
		String jpaql = "from Computer";
		TypedQuery<Computer> query = entityManager.createQuery(jpaql, Computer.class);
		List<Computer> computerList = query.getResultList();
		return computerList;
	}

	@Override
	public List<Computer> allComputersBySupplier(int supplierId) {
		String jpaql = "from Computer where supplierId=:supplier";
		TypedQuery<Computer> query = entityManager.createQuery(jpaql,Computer.class);
		query.setParameter("supplier", supplierId);
		List<Computer> list = query.getResultList();
		return list;
	}
}