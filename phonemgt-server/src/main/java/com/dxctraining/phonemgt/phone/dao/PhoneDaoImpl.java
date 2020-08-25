package com.dxctraining.phonemgt.phone.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.phonemgt.phone.entities.Phone;
import com.dxctraining.phonemgt.phone.exceptions.PhoneNotFoundException;

@Repository
public class PhoneDaoImpl implements IPhoneDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Phone findPhoneById(int id) {
		Phone phone = entityManager.find(Phone.class, id);
		if (phone == null) {
			throw new PhoneNotFoundException("Phone not found for id=" + id);
		}
		return phone;
	}

	@Override
	public Phone add(Phone phone) {
		entityManager.persist(phone);
		return phone;
	}

	@Override
	public void remove(int id) {
		Phone Phone = findPhoneById(id);
		entityManager.remove(Phone);
	}

	public List<Phone> allPhones() {
		String jpaql = "from Phone";
		TypedQuery<Phone> query = entityManager.createQuery(jpaql, Phone.class);
		List<Phone> phoneList = query.getResultList();
		return phoneList;
	}
	
	@Override
	public List<Phone> allPhonesBySupplier(int supplierId) {
		String jpaql = "from Phone where supplierId=:supplier";
		TypedQuery<Phone>query = entityManager.createQuery(jpaql, Phone.class);
		query.setParameter("supplier" ,supplierId);
		List<Phone>list = query.getResultList();
		return list;
	}
}