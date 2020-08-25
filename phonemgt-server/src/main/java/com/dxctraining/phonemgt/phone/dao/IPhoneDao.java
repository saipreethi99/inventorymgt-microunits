package com.dxctraining.phonemgt.phone.dao;

import java.util.List;

import com.dxctraining.phonemgt.phone.entities.Phone;

public interface IPhoneDao {

	Phone add(Phone phone);

	void remove(int id);

	Phone findPhoneById(int id);

	List<Phone> allPhones();
	
	List<Phone>allPhonesBySupplier(int supplierId);
}