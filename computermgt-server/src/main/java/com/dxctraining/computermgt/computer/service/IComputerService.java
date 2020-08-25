package com.dxctraining.computermgt.computer.service;

import java.util.List;

import com.dxctraining.computermgt.computer.entities.Computer;

public interface IComputerService {
	
	Computer findComputerById(int id);

	void remove(int id);

	Computer add(Computer computer);

	List<Computer> allComputers();

	List<Computer> allComputersBySupplier(int supplierId);
}

//boolean authenticate(int id, String password);