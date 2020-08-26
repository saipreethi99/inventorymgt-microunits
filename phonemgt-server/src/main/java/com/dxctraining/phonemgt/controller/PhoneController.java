package com.dxctraining.phonemgt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.dxctraining.phonemgt.phone.dto.CreatePhoneRequest;
import com.dxctraining.phonemgt.phone.dto.PhoneDto;
import com.dxctraining.phonemgt.phone.dto.SupplierDto;
import com.dxctraining.phonemgt.phone.entities.Phone;
import com.dxctraining.phonemgt.phone.service.IPhoneService;
import com.dxctraining.phonemgt.phone.util.PhoneUtil;

@RestController
@RequestMapping("/phones")
public class PhoneController {
	
	@Autowired
	private IPhoneService phoneservice;
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PhoneUtil phoneUtil;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public PhoneDto add(@RequestBody CreatePhoneRequest requestData) {
		String name=requestData.getName();
		int supplierId=requestData.getSupplierId();
		int StorageSize=requestData.getStorageSize();
		Phone phone = new Phone(name,supplierId,StorageSize);
		phoneservice.add(phone);
		SupplierDto supplier = fetchFromSupplierAppById(requestData.getSupplierId());
		PhoneDto response = phoneUtil.phoneDto(phone, supplier.getId(), supplier.getName());
		return response;
	}

	@GetMapping("/get/{id}")
	public PhoneDto getPhone(@PathVariable("id") int id) {
		Phone phone = phoneservice.findPhoneById(id);
		int supplierId = phone.getSupplierId();
		SupplierDto supplier = fetchFromSupplierAppById(supplierId);
		PhoneDto response = phoneUtil.phoneDto(phone, supplier.getId(), supplier.getName());
		return response;
	}

	@GetMapping
	public List<PhoneDto> fetchAll() {
		List<Phone> list = phoneservice.allPhones();
		List<PhoneDto> response = new ArrayList<>();
		for (Phone phone : list) {
			int supplierId = phone.getSupplierId();
			SupplierDto supplier = fetchFromSupplierAppById(supplierId);
			PhoneDto dto = phoneUtil.phoneDto(phone, supplier.getId(), supplier.getName());
			response.add(dto);
		}
		return response;
	}

	@GetMapping("/supplier/{supplierId}")
	public List<PhoneDto> fetchAllPhonesBySupplier(@PathVariable("supplierId") int supplierId) {
		List<Phone> list = phoneservice.allPhonesBySupplier(supplierId);
		List<PhoneDto> response = new ArrayList<>();
		SupplierDto supplier = fetchFromSupplierAppById(supplierId);
		for (Phone phone : list) {
			PhoneDto phoneDto = phoneUtil.phoneDto(phone, supplier.getId(), supplier.getName());
			response.add(phoneDto);
		}
		return response;
	}

	public SupplierDto fetchFromSupplierAppById(int supplierId) {
		String url = "http://localhost:8588/suppliers/get/" + supplierId;
		SupplierDto dto = restTemplate.getForObject(url, SupplierDto.class);
		return dto;
	}

}
	