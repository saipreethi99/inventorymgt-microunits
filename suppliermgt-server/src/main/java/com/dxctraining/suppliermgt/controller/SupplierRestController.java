package com.dxctraining.suppliermgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.dxctraining.suppliermgt.supplier.dto.CreateSupplierRequest;
import com.dxctraining.suppliermgt.supplier.dto.SupplierDto;
import com.dxctraining.suppliermgt.supplier.dto.UpdateSupplierRequest;
import com.dxctraining.suppliermgt.supplier.entities.Supplier;
import com.dxctraining.suppliermgt.supplier.service.ISupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierRestController {
	
	@Autowired
	private ISupplierService supplierservice;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public SupplierDto createSupplier(@RequestBody CreateSupplierRequest supplier) {
		Supplier supplier1 = new Supplier(supplier.getName(), supplier.getPassword());
		supplier1 = supplierservice.add(supplier1);
		SupplierDto response = toDto(supplier1);
		return response;
	}
	
	public SupplierDto toDto(Supplier supplier) {
		SupplierDto dto = new SupplierDto();
		dto.setId(supplier.getId());
		dto.setName(supplier.getName());
		dto.setPassword(supplier.getPassword());
		SupplierDto response = toDto(supplier);
		return dto;
	}
	
	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public SupplierDto getSupplier(@PathVariable("id")int id) {
		Supplier supplier1 = supplierservice.findSupplierById(id);
		SupplierDto response = toDto(supplier1);
		return response;
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public SupplierDto updateSupplier(@RequestBody UpdateSupplierRequest supplier) {
		Supplier supplier1 = new Supplier(supplier.getName(),supplier.getPassword());
		supplier1.setId(supplier.getId());
		supplierservice.update(supplier1);
		SupplierDto response = toDto(supplier1);
		return response;
	}

	@GetMapping("/authenticate/{id}/{password}")
	public boolean authenticate(@PathVariable("id")int id, @PathVariable("password")String password) {
		boolean status = supplierservice.authentication(id, password);
		return status;	
	}
	
}