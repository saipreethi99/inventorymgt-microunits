package com.dxctraining.computermgt.computer.dao;

import java.util.List;

import com.dxctraining.computermgt.computer.entities.Computer;

public interface IComputerDao {

	Computer findComputerById(int id);

	Computer add(Computer computer);

	void remove(int id);

	List<Computer> allComputers();

	List<Computer> allComputersBySupplier(int supplierId);
}