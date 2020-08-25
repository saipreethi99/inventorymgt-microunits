package com.dxctraining.computermgt.computer.util;

import org.springframework.stereotype.Component;
import com.dxctraining.computermgt.computer.dto.ComputerDto;
import com.dxctraining.computermgt.computer.entities.Computer;

@Component
public class ComputerUtil {
	public ComputerDto computerDto(Computer computer, int supplierId, String supplierName) {
		ComputerDto dto = new ComputerDto(computer.getId(), computer.getName(), computer.getDiskSize());
		dto.setSupplierId(supplierId);
		dto.setSupplierName(supplierName);
		return dto;
	}
}