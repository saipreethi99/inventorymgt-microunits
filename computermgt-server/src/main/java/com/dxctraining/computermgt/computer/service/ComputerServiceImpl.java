package com.dxctraining.computermgt.computer.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.computermgt.computer.dao.IComputerDao;
import com.dxctraining.computermgt.computer.entities.Computer;
import com.dxctraining.computermgt.computer.exceptions.InvalidArgumentException;

@Transactional
@Service
public class ComputerServiceImpl implements IComputerService {

	@Autowired
	private IComputerDao dao;

	@Override
	public Computer findComputerById(int id) {
		Computer computer = dao.findComputerById(id);
		return computer;
	}

	@Override
	public Computer add(Computer computer) {
		display(computer);
		computer = dao.add(computer);
		return computer;
	}

	public List<Computer> allComputers() {
		List<Computer> computers = dao.allComputers();
		return computers;
	}

	public void display(Object arg) {
		if (arg == null) {
			throw new InvalidArgumentException("argument is null");
		}

	}

	@Override
	public void remove(int id) {
		dao.remove(id);
	}

	

	@Override
	public List<Computer> allComputersBySupplier(int supplierId) {
		List<Computer>list = dao.allComputersBySupplier(supplierId);
		return list;
	}
}

/*@Override
public boolean authenticate(int id, String name) {
	Computer computer= dao.findComputerById(id);
       boolean equals= storedName.equals(name);
       return equals;
    }*/