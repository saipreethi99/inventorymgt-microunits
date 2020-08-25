package com.dxctraining.phonemgt.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.phonemgt.phone.dao.IPhoneDao;
import com.dxctraining.phonemgt.phone.entities.Phone;
import com.dxctraining.phonemgt.phone.exceptions.InvalidArgumentException;

@Transactional
@Service
public class IPhoneServiceImpl implements IPhoneService {

	@Autowired
	private IPhoneDao dao;

	@Override
	public Phone findPhoneById(int id) {
		Phone phone = dao.findPhoneById(id);
		return phone;
	}

	@Override
	public Phone add(Phone phone) {
		display(phone);
		phone = dao.add(phone);
		return phone;
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
	public List<Phone> allPhones() {
		List<Phone> phones = dao.allPhones();
		return phones;
	}

	@Override
	public List<Phone> allPhonesBySupplier(int supplierId) {
		List<Phone>list = dao.allPhonesBySupplier(supplierId);
		return list;
	}

}