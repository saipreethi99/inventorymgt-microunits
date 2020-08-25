package com.dxctraining.phonemgt.phone.service;

import java.util.List;

import com.dxctraining.phonemgt.phone.entities.Phone;

public interface IPhoneService {
	Phone findPhoneById(int id);

	void remove(int id);

	Phone add(Phone phone);

	List<Phone> allPhones();

	List<Phone> allPhonesBySupplier(int supplierId);

}